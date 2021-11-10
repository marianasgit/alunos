package br.senai.sp.jandira;

import br.senai.sp.jandira.ui.FrameCadastroAlunos;

public class App {

	public static void main(String[] args) {
		
//		AlunoRepository turma = new AlunoRepository(5);
//		
//		Aluno a = new Aluno();
//		a.setNome("Pedro");
//		turma.gravar(a, 0);
//		
//		Aluno b = new Aluno();
//		b.setNome("Ana");
//		turma.gravar(b, 1);
//		
//		Aluno c = new Aluno();
//		c.setNome("Luisa");
//		turma.gravar(c, 2);
//		
//		Aluno d = new Aluno();
//		d.setNome("Joao");
//		turma.gravar(d, 3);
//		
//		Aluno e = new Aluno();
//		e.setNome("Maria");
//		turma.gravar(e, 4);
//		
//		//Exibir os nomes dos alunos da turma
//		for (Aluno alunoAtual : turma.listarTodos()) {
//			System.out.println(alunoAtual.getNome());
//		}
//		
//		int[] x = new int[6];
//		x[0] = 10;
//		x[1] = 5;
//		x[2] = 9;
//		x[3] = 6;
//		x[4] = 78;
//		x[5] = 11;
//		
//		String[] diasDaSemana = {
//				"Segunda",
//				"Terça",
//				"Quarta",
//				"Quinta",
//				"Sexta",
//				"Sabado",
//				"Domingo"};
//		
//		for (int v : x) {
//			System.out.println(v);
//		}
		
		
		FrameCadastroAlunos frame = new FrameCadastroAlunos();
		frame.setVisible(true);
		
	}

}
