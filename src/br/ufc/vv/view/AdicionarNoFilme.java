package br.ufc.vv.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.ufc.vv.control.ControlePessoa;
import br.ufc.vv.control.FilmeControlador;
import br.ufc.vv.control.excecoes.ErroParametros;
import br.ufc.vv.model.Pessoa;
import br.ufc.vv.model.connection.excecoes.ErroNaConexao;
import br.ufc.vv.model.contract.IFilme;
import br.ufc.vv.model.contract.IPessoa;
import br.ufc.vv.model.excecoes.ErroDAO;

public class AdicionarNoFilme extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;
	private FilmeControlador controle;
	private JButton btnSair;
	private List<IFilme> filmes;
	private JButton btnAtualiazar;

	private void preencherTabela(){
		try {
			tableModel.setRowCount(0);
			Iterator<IFilme> filmes = controle.listarFilmes();
			while(filmes.hasNext())
				tableModel.addRow(new String[]{filmes.next().getId().toString(), filmes.next().getTitulo()});
		} catch (ErroNaConexao e) {
			e.printStackTrace();
		}
	}

	public AdicionarNoFilme(final IPessoa pessoa) {
		
		setTitle("Lista de Pessoas");
		controle = new FilmeControlador();
		tableModel = new DefaultTableModel(new Object[]{"Id", "Titulo"}, 0);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 599, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 0, 428, 270);
		contentPane.add(scrollPane);
		
		table = new JTable(tableModel);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setSurrendersFocusOnKeystroke(true);
		scrollPane.setViewportView(table);
		
		preencherTabela();
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setBounds(452, 237, 125, 25);
		contentPane.add(btnSair);
		
		btnAtualiazar = new JButton("Atualizar");
		btnAtualiazar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				preencherTabela();
			}
		});
		btnAtualiazar.setBounds(452, 8, 125, 25);
		contentPane.add(btnAtualiazar);
		
		JButton btnAdicionarPessoa = new JButton("Adicionar");
		btnAdicionarPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(table.getSelectedRow()>-1){
					List<IPessoa> pessoas = new ArrayList<IPessoa>();
					pessoas.add(pessoa);
					try {
						controle.addAtoresDoFilme((Integer)tableModel.getValueAt(0, table.getSelectedRow()), pessoas.iterator());
						JOptionPane.showMessageDialog(null, "Adicionado com sucesso!");
						dispose();
					} catch (ErroNaConexao | ErroDAO | ErroParametros e) {
						JOptionPane.showMessageDialog(null, "Ocorreu um erro na adição.");
					}
			
				}else{
					JOptionPane.showMessageDialog(null, "Selecione um item na tabela.");
				}
			}
		});
		btnAdicionarPessoa.setBounds(452, 37, 125, 25);
		contentPane.add(btnAdicionarPessoa);
	}

}
