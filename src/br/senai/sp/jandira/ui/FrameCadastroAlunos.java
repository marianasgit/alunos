package br.senai.sp.jandira.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import br.senai.sp.jandira.model.Periodo;

public class FrameCadastroAlunos extends JFrame {

	private JPanel contentPane;
	private JTextField txtMatricula;
	private JTextField txtNome;

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
		txtMatricula.setBounds(96, 37, 106, 20);
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
		comboPeriodo.setModel(new DefaultComboBoxModel(Periodo.values()));
		comboPeriodo.setBounds(96, 97, 106, 22);
		contentPane.add(comboPeriodo);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(65, 173, 128, 50);
		contentPane.add(btnSalvar);
		
		JLabel lblListaAlunos = new JLabel("Lista dos Alunos:");
		lblListaAlunos.setBounds(299, 40, 97, 14);
		contentPane.add(lblListaAlunos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(276, 69, 148, 181);
		contentPane.add(scrollPane);
		
		JList listAlunos = new JList();
		scrollPane.setViewportView(listAlunos);
	}
}
