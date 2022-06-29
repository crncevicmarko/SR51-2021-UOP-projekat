package guiFormeZaDodavanjeIIzmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import biblioteka.Biblioteka;
import biblioteka.Zanr;
import net.miginfocom.swing.MigLayout;

public class AddZanr extends JFrame {
	
	private JLabel lblOpis=new JLabel("Opis: ");
	private JTextField txtOpis=new JTextField(20);
	private JLabel lblOznaka=new JLabel("Oznaka: ");
	private JTextField txtOznaka=new JTextField(20);
	private JButton btnOk = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	private Biblioteka biblioteka;
	private Zanr zanr;
	
	public AddZanr(Biblioteka biblioteka) {
		this.biblioteka=biblioteka;
		setSize(500,1000);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		pack();
	}
	public AddZanr(Biblioteka biblioteka,Zanr zanr) {
		this.biblioteka=biblioteka;	
		this.zanr=zanr;
		setTitle("Dodavanje");
		setSize(500,1000);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		pack();
	}
	
	public void initGUI() {
		MigLayout mig = new MigLayout("wrap 2", "[][]", "[]10[][]10[]");
		setLayout(mig);
		add(lblOpis);
		add(txtOpis);
		add(lblOznaka);
		add(txtOznaka);
		add(btnOk);
		add(btnCancel);
		
		if(zanr!=null) {
			txtOpis.setText(zanr.getOpis());
			txtOznaka.setText(zanr.getOznaka());
		}
	}
	public void initActions() {
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddZanr.this.dispose();
				AddZanr.this.setVisible(false);
			}
		});
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String opis=txtOpis.getText().trim();
				String oznaka=txtOznaka.getText().trim();
				
				if(opis.equals("") || oznaka.equals("")) {
					JOptionPane.showMessageDialog(null, "Niste uneli sve podatke za dodavanje.", "Greska", JOptionPane.WARNING_MESSAGE);
				}
				else {
					if(zanr==null) {
						String id= Integer.toString(biblioteka.getZanrovi().size());	
						Zanr noviZanr= new Zanr(id,opis,oznaka,false);
						biblioteka.getZanrovi().add(noviZanr);
					}
					else {
						zanr.setOpis(opis);
						zanr.setOznaka(oznaka);
					}
					try {
						biblioteka.sacuvajZanrove();
						AddZanr.this.setVisible(false);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					}
			}
	});
	
}}
