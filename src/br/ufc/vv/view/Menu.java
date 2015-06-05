package br.ufc.vv.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Menu() {
		setTitle("Menu Fictício");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 139);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnPessoa = new JMenu("Pessoa");
		JMenu mnFilme = new JMenu("Filme");
		menuBar.add(mnPessoa);
		menuBar.add(mnFilme);
		
		JMenuItem mntmListarPessoas = new JMenuItem("Listar");
		mntmListarPessoas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarPessoas listar = new ListarPessoas();
				listar.setVisible(true);
			}
		});
		mnPessoa.add(mntmListarPessoas);
		
		JMenuItem mntmCadastrarFilme = new JMenuItem("Cadastrar");
		mntmCadastrarFilme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarFilme filme = new CadastrarFilme();
				filme.setVisible(true);
			}
		});
		mnFilme.add(mntmCadastrarFilme);
		
		
		JMenuItem mntmNewMenuCadstraritem = new JMenuItem("Cadastrar");
		mntmNewMenuCadstraritem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroPessoa cadastro = new CadastroPessoa();
				cadastro.setVisible(true);
			}
		});
		mnPessoa.add(mntmNewMenuCadstraritem);
	}

}
