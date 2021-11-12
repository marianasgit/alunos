package br.senai.sp.jandira.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import br.senai.sp.jandira.model.Aluno;
import br.senai.sp.jandira.model.Periodo;
import br.senai.sp.jandira.repository.AlunoRepository;

public class FrameCadastroAlunos extends JFrame {

	private JPanel contentPane;
	private JTextField txtMatricula;
	private JTextField txtNome;

	private int posicao;

	public FrameCadastroAlunos() {
		setTitle("Cadastro de Alunos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMatricula = new JLabel("Matr\u00EDcula:");
		lblMatricula.setBounds(28, 40, 71, 14);
		contentPane.add(lblMatricula);

		txtMatricula = new JTextField();
		txtMatricula.setBounds(96, 37, 153, 20);
		contentPane.add(txtMatricula);
		txtMatricula.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(28, 69, 47, 14);
		contentPane.add(lblNome);

		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(96, 66, 153, 20);
		contentPane.add(txtNome);

		JLabel lblPeriodo = new JLabel("Per\u00EDodo:");
		lblPeriodo.setBounds(28, 101, 60, 14);
		contentPane.add(lblPeriodo);

		JComboBox comboPeriodo = new JComboBox();

		// Criar o DefaultCombobox, que é um vetor que carrega os dados que serão
		// exibidos no combo
		DefaultComboBoxModel<String> comboModelPeriodo = new DefaultComboBoxModel<String>();

		// Carregar o comboModel com as descrições do Periodo
		for (Periodo descricao : Periodo.values()) {
			comboModelPeriodo.addElement(descricao.getDescricao());
		}

		comboPeriodo.setModel(comboModelPeriodo);
		comboPeriodo.setBounds(96, 97, 106, 22);
		contentPane.add(comboPeriodo);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(64, 163, 138, 38);
		contentPane.add(btnSalvar);

		JLabel lblListaAlunos = new JLabel("Lista dos Alunos:");
		lblListaAlunos.setBounds(310, 40, 97, 14);
		contentPane.add(lblListaAlunos);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(276, 69, 148, 181);
		contentPane.add(scrollPane);

		JList listAlunos = new JList();
		scrollPane.setViewportView(listAlunos);

		// criar o model que vai exibir os alunos na JList
		DefaultListModel<String> modelAlunos = new DefaultListModel<String>();

		// Definir o modelAlunos como model do JList
		listAlunos.setModel(modelAlunos);

		JButton btnMostrarAlunos = new JButton("Mostrar Todos");
		btnMostrarAlunos.setBounds(64, 212, 138, 38);
		contentPane.add(btnMostrarAlunos);

		// Criar uma turma que é um repositório de alunos
		AlunoRepository turma = new AlunoRepository(3);

		btnSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Aluno aluno = new Aluno();
				aluno.setMatricula(txtMatricula.getText());
				aluno.setNome(txtNome.getText());

				// Definir o horário que o aluno estuda
				aluno.setPeriodo(determinarPeriodo(comboPeriodo.getSelectedIndex()));

				turma.gravar(aluno, posicao);

				modelAlunos.addElement(aluno.getNome());

				posicao++;

				if (posicao == turma.getTamanho()) {
					btnSalvar.setEnabled(false); // propriedade para desativar o botão ao atingir limite de aluno
					JOptionPane.showMessageDialog(null, "A turma já está cheia!", "Atenção!", JOptionPane.ERROR_MESSAGE); // propriedade para mostrar alerta
				}

			}
		});

		btnMostrarAlunos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (Aluno aluno : turma.listarTodos()) {
					System.out.println(aluno.getNome());
					System.out.println(aluno.getMatricula());
					System.out.println(aluno.getPeriodo().getDescricao());
					System.out.println("-----------------------");
				}

			}
		});
		
	listAlunos.addListSelectionListener(new ListSelectionListener() {
		
		@Override
		public void valueChanged(ListSelectionEvent e) {
			
			Aluno aluno = turma.listarAluno(listAlunos.getSelectedIndex());
			txtMatricula.setText(aluno.getMatricula());
			txtNome.setText(aluno.getNome());
			comboPeriodo.setSelectedIndex(aluno.getPeriodo().ordinal());
			
		}
	});
		
	
	}

	private Periodo determinarPeriodo(int periodoSelecionado) {
		if (periodoSelecionado == 0) {
			return Periodo.MANHA;
		} else if (periodoSelecionado == 1) {
			return Periodo.TARDE;
		} else if (periodoSelecionado == 2) {
			return Periodo.NOITE;
		} else if (periodoSelecionado == 3) {
			return Periodo.SABADO;
		} else {
			return Periodo.ONLINE;

		}

	}
}
