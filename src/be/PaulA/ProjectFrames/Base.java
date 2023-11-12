package be.PaulA.ProjectFrames;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import be.PaulA.pojo.Match;
import be.PaulA.pojo.Schedule;
import be.PaulA.pojo.Tournament;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class Base extends JFrame {

	private JPanel contentPane;
	private Tournament t;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Base frame = new Base();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Base() {
		t = new Tournament("Rolan Garros");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 595);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		
		
		DefaultTableModel model = new DefaultTableModel(new String[] {"Joueur1","Joueur2","Match nbr"},0);
		int i=1;
		for(Match m : t.getSchedules()[0].getMatches()) {
			if(m.getOpp1()!=null&&m.getOpp2()!=null) {
			//System.out.println(m.getOpp1().toString()+"    "+m.getOpp2().toString());
			model.addRow(new Object[] {m.getOpp1().toString(),m.getOpp2().toString(),i});
			}
			i++;
		}
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 724, 484);
		contentPane.add(scrollPane);
		
		table = new JTable(model);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(308, 506, 118, 39);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//t.play();
				t.getSchedules()[0].playNextRound();
				Base testPage = new Base(t);
				testPage.setVisible(true);
			}
		});
	}
	public Base(Tournament t) {
		this.t=t;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 595);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		
		
		DefaultTableModel model = new DefaultTableModel(new String[] {"Joueur1","Joueur2","Result"/*,"Winner"*/},0);
		int i=1;
		for(Match m : t.getSchedules()[0].getMatches()) {
			if((m.getOpp1()!=null&&m.getOpp2()!=null)&&m.getRound()==t.getSchedules()[0].getActualRound()-1) {
				//System.out.println(m.getOpp1().toString()+"    "+m.getOpp2().toString());
				model.addRow(new Object[] {m.getOpp1().toString(),m.getOpp2().toString(),m.toString()/*,m.getWinner().toString()*/});
				//t.getSchedules()[0].getMatches().remove(m);
			}
			i++;
		}
		System.out.println("");
		System.out.println("");
		System.out.println("");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 724, 484);
		contentPane.add(scrollPane);
		
		table = new JTable(model);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(308, 506, 118, 39);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//t.play();
				if(t.getSchedules()[0].getWinner()==null) {
					t.getSchedules()[0].playNextRound();
					System.out.println("Il est null");
				}else {
					JOptionPane.showMessageDialog(null, "AND THE WINNER IS : " +t.getSchedules()[0].getWinner().toString());
					System.out.println("Il est pas null");
				}
				Base testPage = new Base(t);
				testPage.setVisible(true);
			}
		});
	}
}
