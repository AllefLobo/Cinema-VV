package br.ufc.vv.visao;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import br.ufc.vv.controle.ControladorProgramacaoImpl;
import br.ufc.vv.controle.IControladorEvento;
import br.ufc.vv.controle.IControladorProgramacao;
import br.ufc.vv.exception.DataInvalidaException;
import br.ufc.vv.modelo.IProgramacao;

public class ProgramacaoGUIImpl implements IProgramacaoGUI{

	private JFrame framePrincipal;
	private IControladorProgramacao controladorProgramacao ;

	 
	public ProgramacaoGUIImpl(){
		initialize();
		IControladorEvento controladorDeEvento =  new ControladorDeEventosImpl();
		controladorProgramacao = new ControladorProgramacaoImpl(controladorDeEvento);
		framePrincipal.setVisible(true);
	}

	private void initialize() {
		framePrincipal =  new JFrame();
		framePrincipal.setBounds(100, 100, 450, 300);
		framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNomeCinema = new JLabel("Nome Cinema");
		lblNomeCinema.setBounds(12, 12, 424, 21);
		lblNomeCinema.setFont(new Font("Droid Sans", Font.BOLD, 14));
		lblNomeCinema.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblEscolherPrograma = new JLabel("Escolher Programação");
		lblEscolherPrograma.setBounds(12, 45, 179, 38);
		framePrincipal.getContentPane().setLayout(null);
		framePrincipal.getContentPane().add(lblNomeCinema);
		framePrincipal.getContentPane().add(lblEscolherPrograma);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 85, 424, 120);
		framePrincipal.getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnSemanaAtual = new JButton("Semana Atual");
		panel.add(btnSemanaAtual);
		btnSemanaAtual.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Calendar dataAtual = Calendar.getInstance();
				dataAtual.setTimeInMillis(System.currentTimeMillis());
				try {
					IProgramacao programacao = controladorProgramacao.buscarProgramacaoDaSemana(dataAtual);
					ListarProgramacaoGUI listarProgramacao = new ListarProgramacaoGUI(programacao);
				
				} catch (DataInvalidaException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(framePrincipal, "Datá Inválida");
				}
				
			}
		});
		
		JButton btnEscolherData = new JButton("Escolher Data");
		panel.add(btnEscolherData);
		
		btnEscolherData.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String dataInicioString = JOptionPane.showInputDialog("Diga a data de início da semana : ");
				String dataFimString = JOptionPane.showInputDialog("Diga a data de fim : ");
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				try {
					Date dataInicio = format.parse(dataInicioString);
					Calendar calendarDataInicio = Calendar.getInstance();
					calendarDataInicio.setTime(dataInicio);
					

					Date dataFim = format.parse(dataFimString);
					Calendar calendarDataFim = Calendar.getInstance();
					calendarDataInicio.setTime(dataFim);
					
					
					List<IProgramacao> programacoes =  controladorProgramacao.buscarProgramacoesPorIntervalo(calendarDataInicio, calendarDataFim);
					if(programacoes.size() != 0){
						for (IProgramacao programacao : programacoes) {
							ListarProgramacaoGUI listarProgramacao = new ListarProgramacaoGUI(programacao);
						}
					}
					
				} catch (ParseException | DataInvalidaException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Informe a data no formato : dd/mm/yyyy Ex : 10/02/2004");
				}
			}
		});
		
	}

	@Override
	public void init() {
		initialize();
	}
}
