package br.ufc.vv.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import br.ufc.vv.control.CinemaControl;
import br.ufc.vv.model.Cinema;

public class VisualizarCinemaGUI {

	private JFrame frmVisualizarCinema;
	private CinemaControl cinemaControl;
	private JLabel nomeCinema;
	private JLabel enderecoCinema;

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public VisualizarCinemaGUI() {
		while(cinemaExiste() == false){
			
			String nome = JOptionPane.showInputDialog("Digite o nome do cinema!");
			String endereco = JOptionPane.showInputDialog("Digite o endere�o do cinema!");
				
			cinemaControl.criarCinema(nome, endereco);
				
				
			if(!cinemaExiste()){
				JOptionPane.showMessageDialog(null, "Erro ao adicionar cinema!");
				
			}
		}
		
		initialize();
		
		Cinema cinema = (Cinema) cinemaControl.buscarCinema();
		
		atualizaGUI(cinema);
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		frmVisualizarCinema = new JFrame();
		frmVisualizarCinema.setResizable(false);
		frmVisualizarCinema.setTitle("Visualizar Cinema");
		frmVisualizarCinema.setBounds(100, 100, 500, 270);
		frmVisualizarCinema.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVisualizarCinema.setLocationRelativeTo(null);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SwingUtilities.updateComponentTreeUI(frmVisualizarCinema);
		frmVisualizarCinema.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 494, 242);
		frmVisualizarCinema.getContentPane().add(panel);
		panel.setLayout(null);
		
		nomeCinema = new JLabel("");
		nomeCinema.setBounds(7, 7, 334, 40);
		panel.add(nomeCinema);
		
		enderecoCinema = new JLabel("");
		enderecoCinema.setBounds(7, 58, 467, 40);
		panel.add(enderecoCinema);
		
		JButton btnEditarInformaes = new JButton("Editar Informa��es");
		btnEditarInformaes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = JOptionPane.showInputDialog("Digite o nome do cinema!");
				String endereco = JOptionPane.showInputDialog("Digite o endere�o do cinema!");
					
				cinemaControl.atualizarCinema(new Cinema(nome, endereco));
			}
		});
		btnEditarInformaes.setBounds(351, 7, 123, 23);
		panel.add(btnEditarInformaes);
		
		JLabel lblVejaANossa = new JLabel("Confira a nossa programa��o!");
		lblVejaANossa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVejaANossa.setHorizontalAlignment(SwingConstants.CENTER);
		lblVejaANossa.setBounds(130, 140, 218, 40);
		panel.add(lblVejaANossa);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(7, 130, 477, 10);
		panel.add(separator);
		
		JButton btnProgramao = new JButton("Programa��o");
		btnProgramao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cinemaControl.mostrarProgramacao();
				frmVisualizarCinema.dispose();
			}
		});
		btnProgramao.setBounds(194, 197, 102, 23);
		panel.add(btnProgramao);
		
		frmVisualizarCinema.setVisible(true);
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	private boolean cinemaExiste(){
		if(cinemaControl.buscarCinema() != null){
			return true;
		}
		return false;
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	private void atualizaGUI(Cinema cinema){
		nomeCinema.setText(cinema.getNome());
		enderecoCinema.setText(cinema.getEndereco());
	}
}
