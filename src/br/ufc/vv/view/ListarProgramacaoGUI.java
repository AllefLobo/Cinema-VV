package br.ufc.vv.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import br.ufc.vv.model.IEvento;
import br.ufc.vv.model.IProgramacao;

public class ListarProgramacaoGUI extends JFrame {

	private JPanel contentPane;
	private IProgramacao programacao;

	/**
	 * Create the frame.
	 */
	public ListarProgramacaoGUI(IProgramacao programacao) {
		this.programacao = programacao;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCinema = new JLabel();
		//lblCinema.setText(cinema.getNome());
		lblCinema.setHorizontalAlignment(SwingConstants.CENTER);
		lblCinema.setFont(new Font("Droid Sans", Font.BOLD, 14));
		lblCinema.setBounds(12, 12, 424, 21);
		contentPane.add(lblCinema);
		
		JLabel lblProgramaoSemana = new JLabel("Programa��o Semana : ");
		Locale.setDefault(new Locale("pt","br"));
		int mes = programacao.getDiaInicial().get(Calendar.MONTH)+1;
		int ano = programacao.getDiaInicial().get(Calendar.YEAR);
		int dia = programacao.getDiaInicial().get(Calendar.DAY_OF_MONTH);
		lblProgramaoSemana.setText(lblProgramaoSemana.getText() + dia+"/"+mes+"/"+ano);
		lblProgramaoSemana.setBounds(22, 45, 414, 39);
		contentPane.add(lblProgramaoSemana);
		
		JPanel panel = new JPanel();
		panel.setBounds(22, 94, 414, 168);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		DefaultListModel<IEvento> eventosModel =  new DefaultListModel<IEvento>();
		
		Iterator<IEvento> eventos = programacao.getEventos();
		
		while(eventos.hasNext()){
			IEvento evento = eventos.next();
			
			eventosModel.addElement(evento);
		}
		
		JList list = new JList(eventosModel);
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				System.out.println(e.getSource());
				
				JOptionPane.showMessageDialog(null, e.getSource());
				
			}
		});
		
		scrollPane.setViewportView(list);
		
		setVisible(true);
		
	}
}
