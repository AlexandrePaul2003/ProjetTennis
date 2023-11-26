package be.PaulA.ProjectFrames;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import be.PaulA.pojo.Match;
import be.PaulA.pojo.Tournament;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ScrollPaneConstants;

public class Tous extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JTable table_4;
	private Tournament t;
	private int currTurn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tous frame = new Tous();
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
	public Tous() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1265, 574);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		 t = new Tournament("test");
		 currTurn = 0;
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 29, 326, 246);
		contentPane.add(scrollPane);
		DefaultTableModel model = new DefaultTableModel(new String[] {"Joueur1","Joueur2","Match nbr"},0);
		int i=1;
		for(Match m : t.getSchedules()[0].getMatches()) {
			if(m.getOpp1()!=null&&m.getOpp2()!=null) {
			//System.out.println(m.getOpp1().toString()+"    "+m.getOpp2().toString());
			model.addRow(new Object[] {m.getOpp1().toString(),m.getOpp2().toString(),i});
			}
			i++;
		}
		
		table = new JTable(model);
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(2).setPreferredWidth(10);
		
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 286, 326, 225);
		contentPane.add(scrollPane_1);
		
		DefaultTableModel model1 = new DefaultTableModel(new String[] {"Joueur1","Joueur2","Match nbr"},0);
		i=1;
		for(Match m : t.getSchedules()[1].getMatches()) {
			if(m.getOpp1()!=null&&m.getOpp2()!=null) {
			//System.out.println(m.getOpp1().toString()+"    "+m.getOpp2().toString());
			model1.addRow(new Object[] {m.getOpp1().toString(),m.getOpp2().toString(),i});
			}
			i++;
		}
		table_1 = new JTable(model1);
		columnModel = table_1.getColumnModel();
		columnModel.getColumn(2).setPreferredWidth(10);
		scrollPane_1.setViewportView(table_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_2.setBounds(346, 29, 424, 246);
		contentPane.add(scrollPane_2);
		
		DefaultTableModel model2 = new DefaultTableModel(new String[] {"Joueur1","Joueur2","Match nbr"},0);
		i=1;
		for(Match m : t.getSchedules()[2].getMatches()) {
			if(m.getOpp1()!=null&&m.getOpp2()!=null) {
			//System.out.println(m.getOpp1().toString()+"    "+m.getOpp2().toString());
			model2.addRow(new Object[] {m.getOpp1().toString(),m.getOpp2().toString(),i});
			}
			i++;
		}
		
		table_2 = new JTable(model2);
		columnModel = table_2.getColumnModel();
		columnModel.getColumn(2).setPreferredWidth(10);
		scrollPane_2.setViewportView(table_2);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(346, 286, 424, 225);
		contentPane.add(scrollPane_3);
		
		DefaultTableModel model3 = new DefaultTableModel(new String[] {"Joueur1","Joueur2","Match nbr"},0);
		i=1;
		for(Match m : t.getSchedules()[3].getMatches()) {
			if(m.getOpp1()!=null&&m.getOpp2()!=null) {
			//System.out.println(m.getOpp1().toString()+"    "+m.getOpp2().toString());
			model3.addRow(new Object[] {m.getOpp1().toString(),m.getOpp2().toString(),i});
			}
			i++;
		}
		
		table_3 = new JTable(model3);
		columnModel = table_3.getColumnModel();
		columnModel.getColumn(2).setPreferredWidth(10);
		scrollPane_3.setViewportView(table_3);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_4.setBounds(780, 29, 459, 482);
		contentPane.add(scrollPane_4);
		
		DefaultTableModel model4 = new DefaultTableModel(new String[] {"Joueur1","Joueur2","Match nbr"},0);
		i=1;
		for(Match m : t.getSchedules()[4].getMatches()) {
			if(m.getOpp1()!=null&&m.getOpp2()!=null) {
			//System.out.println(m.getOpp1().toString()+"    "+m.getOpp2().toString());
			model4.addRow(new Object[] {m.getOpp1().toString(),m.getOpp2().toString(),i});
			}
			i++;
		}
		
		table_4 = new JTable(model4);
		columnModel = table_4.getColumnModel();
		columnModel.getColumn(2).setPreferredWidth(10);
		scrollPane_4.setViewportView(table_4);
		
		JButton bouton = new JButton("Avancer");
		bouton.setBounds(1005, 512, 89, 23);
		contentPane.add(bouton);
		
		JLabel lblNewLabel = new JLabel("Simple homme");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(135, 4, 111, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblDoubleHomme = new JLabel("Double hommes");
		lblDoubleHomme.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDoubleHomme.setBounds(474, 4, 111, 14);
		contentPane.add(lblDoubleHomme);
		
		JLabel lblDoubleFemme = new JLabel("Double Femmes");
		lblDoubleFemme.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDoubleFemme.setBounds(474, 516, 111, 14);
		contentPane.add(lblDoubleFemme);
		
		JLabel lblSimpleFemme = new JLabel("Simple femme");
		lblSimpleFemme.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSimpleFemme.setBounds(135, 516, 111, 14);
		contentPane.add(lblSimpleFemme);
		
		JLabel lblDoubleMixte = new JLabel("Double Mixte");
		lblDoubleMixte.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDoubleMixte.setBounds(960, 6, 111, 14);
		contentPane.add(lblDoubleMixte);
		
		
		
		bouton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				t.play();
				
				System.out.println("On été joué");
				Tous testPage = new Tous(t,1);
				testPage.setVisible(true);
			}
		});
	}
	
	public Tous(Tournament t,int currRound) {
		this.t=t;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1265, 574);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		currTurn = currRound;
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(10, -4, 101, 22);
		contentPane.add(menuBar);
		JMenu menu = new JMenu("Détails");
		menuBar.add(menu);
		JMenuItem m1 = new JMenuItem("Simple homme");
		JMenuItem m2 = new JMenuItem("Simple femme ");
		JMenuItem m3 = new JMenuItem("Double hommes");
		JMenuItem m4 = new JMenuItem("Double femme");
		JMenuItem m5 = new JMenuItem("Double mixte");
		menu.add(m1);
		menu.add(m2);
		menu.add(m3);
		menu.add(m4);
		menu.add(m5);
		m1.addActionListener( this::ouvrirMenu );
		m2.addActionListener( this::ouvrirMenu );
		m3.addActionListener( this::ouvrirMenu );
		m4.addActionListener( this::ouvrirMenu );
		m5.addActionListener( this::ouvrirMenu );
		
		/*setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1244, 574);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));*/

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 29, 326, 246);
		contentPane.add(scrollPane);
		DefaultTableModel model = new DefaultTableModel(new String[] {"Joueur1","Joueur2","Result"},0);
		int i=1;
		for(Match m : t.getSchedules()[0].getMatches()) {
			if(m.getOpp1()!=null&&m.getOpp2()!=null&&m.getRound()==currRound) {
			//System.out.println(m.getOpp1().toString()+"    "+m.getOpp2().toString());
			model.addRow(new Object[] {m.getOpp1().toString(),m.getOpp2().toString(),m.getOpp1().getSets().size()+"-"+m.getOpp2().getSets().size()});
			}
			i++;
		}
		
		table = new JTable(model);
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(2).setPreferredWidth(10);
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 286, 326, 225);
		contentPane.add(scrollPane_1);
		
		DefaultTableModel model1 = new DefaultTableModel(new String[] {"Joueur1","Joueur2","Result"},0);
		i=1;
		for(Match m : t.getSchedules()[1].getMatches()) {
			if(m.getOpp1()!=null&&m.getOpp2()!=null&&m.getRound()==currRound) {
			//System.out.println(m.getOpp1().toString()+"    "+m.getOpp2().toString());
			model1.addRow(new Object[] {m.getOpp1().toString(),m.getOpp2().toString(),m.getOpp1().getSets().size()+"-"+m.getOpp2().getSets().size()});
			}
			i++;
		}
		table_1 = new JTable(model1);
		 columnModel = table_1.getColumnModel();
		columnModel.getColumn(2).setPreferredWidth(10);
		scrollPane_1.setViewportView(table_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(346, 29, 424, 246);
		contentPane.add(scrollPane_2);
		
		DefaultTableModel model2 = new DefaultTableModel(new String[] {"Joueur1","Joueur2","Result"},0);
		i=1;
		for(Match m : t.getSchedules()[2].getMatches()) {
			if(m.getOpp1()!=null&&m.getOpp2()!=null&&m.getRound()==currRound) {
			//System.out.println(m.getOpp1().toString()+"    "+m.getOpp2().toString());
			model2.addRow(new Object[] {m.getOpp1().toString(),m.getOpp2().toString(),m.getOpp1().getSets().size()+"-"+m.getOpp2().getSets().size()});
			}
			i++;
		}
		
		table_2 = new JTable(model2);
		columnModel = table_2.getColumnModel();
		columnModel.getColumn(2).setPreferredWidth(10);
		scrollPane_2.setViewportView(table_2);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(346, 286, 424, 225);
		contentPane.add(scrollPane_3);
		
		DefaultTableModel model3 = new DefaultTableModel(new String[] {"Joueur1","Joueur2","Result"},0);
		i=1;
		for(Match m : t.getSchedules()[3].getMatches()) {
			if(m.getOpp1()!=null&&m.getOpp2()!=null&&m.getRound()==currRound) {
			//System.out.println(m.getOpp1().toString()+"    "+m.getOpp2().toString());
			model3.addRow(new Object[] {m.getOpp1().toString(),m.getOpp2().toString(),m.getOpp1().getSets().size()+"-"+m.getOpp2().getSets().size()});
			}
			i++;
		}
		
		table_3 = new JTable(model3);
		columnModel = table_1.getColumnModel();
		columnModel.getColumn(2).setPreferredWidth(10);
		scrollPane_3.setViewportView(table_3);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(780, 29, 459, 482);
		contentPane.add(scrollPane_4);
		
		DefaultTableModel model4 = new DefaultTableModel(new String[] {"Joueur1","Joueur2","Result"},0);
		i=1;
		for(Match m : t.getSchedules()[4].getMatches()) {
			if(m.getOpp1()!=null&&m.getOpp2()!=null&&m.getRound()==currRound) {
			//System.out.println(m.getOpp1().toString()+"    "+m.getOpp2().toString());
			model4.addRow(new Object[] {m.getOpp1().toString(),m.getOpp2().toString(),m.getOpp1().getSets().size()+"-"+m.getOpp2().getSets().size()});
			}
			i++;
		}
		
		table_4 = new JTable(model4);
		columnModel = table_4.getColumnModel();
		columnModel.getColumn(2).setPreferredWidth(10);
		scrollPane_4.setViewportView(table_4);
		
		JButton bouton = new JButton("Avancer");
		bouton.setBounds(1005, 512, 89, 23);
		contentPane.add(bouton);
		bouton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				t.play();
				
				Tous testPage = new Tous(t,currRound+1);
				testPage.setVisible(true);
			}
		});
		JLabel lblNewLabel = new JLabel("Simple homme");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(135, 4, 111, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblDoubleHomme = new JLabel("Double hommes");
		lblDoubleHomme.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDoubleHomme.setBounds(474, 4, 111, 14);
		contentPane.add(lblDoubleHomme);
		
		JLabel lblDoubleFemme = new JLabel("Double Femmes");
		lblDoubleFemme.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDoubleFemme.setBounds(474, 516, 111, 14);
		contentPane.add(lblDoubleFemme);
		
		JLabel lblSimpleFemme = new JLabel("Simple femme");
		lblSimpleFemme.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSimpleFemme.setBounds(135, 516, 111, 14);
		contentPane.add(lblSimpleFemme);
		
		JLabel lblDoubleMixte = new JLabel("Double Mixte");
		lblDoubleMixte.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDoubleMixte.setBounds(960, 6, 111, 14);
		contentPane.add(lblDoubleMixte);
	}
	public void ouvrirMenu(ActionEvent e)
    {
		Base page=null;
		switch(e.getActionCommand().toString()){
		
			case"Simple homme":
				page = new Base(t,currTurn,0);
				break;
			case"Simple femme ":
				page = new Base(t,currTurn,1);
				break;
			case"Double hommes":
				page = new Base(t,currTurn,2);
				break;
			case"Double femme":
				page = new Base(t,currTurn,3);
				break;
			case"Double mixte":
				page = new Base(t,currTurn,4);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Erreur d'ouverture de menu ! ");
				break;
				
			
		}
		if (page!=null)
		page.setVisible(true);
    }
}
