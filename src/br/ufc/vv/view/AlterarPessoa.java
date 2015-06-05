package br.ufc.vv.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.ufc.vv.control.ControlePessoa;
import br.ufc.vv.control.excecoes.ErroParametros;
import br.ufc.vv.model.Pessoa;
import br.ufc.vv.model.excecoes.ErroDAO;

public class AlterarPessoa extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel label_1;
	private JTextField textField_3;
	private JLabel label_2;
	private ControlePessoa controle;
	private IPessoasAlteradas alterada;
	
	public void setPessoasAlteradas(IPessoasAlteradas alteradas){
		this.alterada = alteradas;
	}

	/**
	 * Create the frame.
	 */
	public AlterarPessoa(final Pessoa pessoa) {
	controle = new ControlePessoa();
		
		setTitle("Alteração de Pessoa");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 298, 225);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nome = new JLabel("Nome:");
		nome.setBounds(23, 12, 52, 19);
		contentPane.add(nome);
		
		textField = new JTextField(pessoa.getNome());
		textField.setBounds(77, 12, 192, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField(pessoa.getSalario().toString());
		textField_1.setColumns(10);
		textField_1.setBounds(87, 43, 182, 19);
		contentPane.add(textField_1);
		
		JLabel label = new JLabel("Salario:");
		label.setBounds(23, 43, 71, 19);
		contentPane.add(label);
		
		textField_2 = new JTextField(pessoa.getIdade().toString());
		textField_2.setColumns(10);
		textField_2.setBounds(77, 74, 192, 19);
		contentPane.add(textField_2);
		
		label_1 = new JLabel("Idade:");
		label_1.setBounds(23, 74, 52, 19);
		contentPane.add(label_1);
		
		textField_3 = new JTextField(pessoa.getRg().toString());
		textField_3.setColumns(10);
		textField_3.setBounds(54, 105, 215, 19);
		contentPane.add(textField_3);
		
		label_2 = new JLabel("Rg:");
		label_2.setBounds(23, 105, 52, 19);
		contentPane.add(label_2);
		
		JButton btnCadastrar = new JButton("Alterar");
	
		btnCadastrar.setBounds(23, 164, 117, 25);
		contentPane.add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setBounds(152, 164, 117, 25);
		contentPane.add(btnCancelar);
		
		final JComboBox comboBox = new JComboBox(new String[]{"Ator", "Diretor"});
		
		comboBox.setSelectedItem(pessoa.getTipo());
		
		comboBox.setBounds(64, 128, 205, 24);
		
		contentPane.add(comboBox);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(24, 133, 44, 15);
		contentPane.add(lblTipo);
	
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Pessoa p = new Pessoa(textField.getText(), Double.parseDouble(textField_1.getText()), Integer.parseInt(textField_2.getText()), Integer.parseInt(textField_3.getText()), comboBox.getSelectedItem().toString());
					p.setId(pessoa.getId());
					controle.alterarPessoa(p);
					JOptionPane.showMessageDialog(null, "Pessoa alterada com sucesso!");
					dispose();
					if(alterada!=null)
						alterada.alterada();
				} catch (NumberFormatException|ErroParametros e) {
					JOptionPane.showMessageDialog(null, "Preencha os Campos Corretamente");
				} catch (ErroDAO e) {
					JOptionPane.showMessageDialog(null, "Ocorreu um erro Interno!");
					System.exit(0);
				}
			}
		});
	}
}
