package br.ufc.vv.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.ufc.vv.control.ControlePessoa;
import br.ufc.vv.control.excecoes.ErroParametros;
import br.ufc.vv.model.Pessoa;
import br.ufc.vv.model.contract.IPessoa;
import br.ufc.vv.model.excecoes.ErroDAO;

public class ListarPessoas extends JFrame implements IPessoasAlteradas{
	
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;
	private ControlePessoa controle;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnSair;
	private List<IPessoa> pessoas;
	private JButton btnAtualiazar;

	private void preencherTabela(){
		try {
			tableModel.setRowCount(0);
			pessoas = controle.buscarTodasPessoas();
			for(IPessoa pessoa : pessoas)
				tableModel.addRow(new String[]{pessoa.getId().toString(), pessoa.getNome(), pessoa.getRg().toString(),pessoa.getIdade().toString(), pessoa.getSalario().toString(), pessoa.getTipo()});
		} catch (ErroDAO e) {
			e.printStackTrace();
		}
		
	}
	
	public ListarPessoas() {
		setTitle("Lista de Pessoas");
		controle = new ControlePessoa();
		tableModel = new DefaultTableModel(new Object[]{"Id", "Nome", "Rg", "Idade", "Salario", "Tipo"}, 0);
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
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(table.getSelectedRow()>-1){
						Pessoa selecionada = (Pessoa) pessoas.get(table.getSelectedRow());
						AlterarPessoa alterar = new AlterarPessoa(selecionada);
						alterar.setPessoasAlteradas(ListarPessoas.this);
						alterar.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "Selecione a linha que corresponde a pessoa que deseja alterar");
				}
			}
		});
		btnAlterar.setBounds(452, 66, 125, 25);
		contentPane.add(btnAlterar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()>-1){
					Pessoa selecionada = (Pessoa) pessoas.get(table.getSelectedRow());
					try {
						controle.removerPessoa(selecionada);
						preencherTabela();
					} catch (ErroParametros e1) {
						e1.printStackTrace();
					} catch (ErroDAO e1) {
						e1.printStackTrace();
					}
				}else
				JOptionPane.showMessageDialog(null, "Selecione a linha que corresponde a pessoa que deseja alterar");
			}
		});
		btnExcluir.setBounds(452, 95, 125, 25);
		contentPane.add(btnExcluir);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setBounds(452, 237, 103, 25);
		contentPane.add(btnSair);
		
		btnAtualiazar = new JButton("Atualizar");
		btnAtualiazar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				preencherTabela();
			}
		});
		btnAtualiazar.setBounds(452, 8, 125, 25);
		contentPane.add(btnAtualiazar);
		
		JButton btnAdicionarPessoa = new JButton("Add No Filme");
		btnAdicionarPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(table.getSelectedRow()>-1){
					IPessoa pessoa = pessoas.get(table.getSelectedRow());
					AdicionarNoFilme adicionar = new AdicionarNoFilme(pessoa);
				}else
				JOptionPane.showMessageDialog(null, "Selecione a linha que corresponde a pessoa que deseja adicionar");
			}
		});
		btnAdicionarPessoa.setBounds(452, 37, 125, 25);
		contentPane.add(btnAdicionarPessoa);
	}

		
	@Override
	public void alterada() {
		preencherTabela();
	}
}
