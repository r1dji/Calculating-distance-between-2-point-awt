package zad3gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Rastojanje2Tacke extends Frame {
	
	public Rastojanje2Tacke() {
		setTitle("Racunanje rastojanja");
		setVisible(true);
		setResizable(true);
		setBounds(700, 200, 500, 300);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		populateWindow();
		
		pack();
	}
	
	private void populateWindow() {
		Panel tackeIDugmePanel = new Panel(new GridLayout(0, 1, 0, 5));
		Panel zaTackePanel = new Panel(new GridLayout(0, 2, 5, 5));
		
		Label tacka1Label = new Label("Tacka 1: ");
		Label tacka2Label = new Label("Tacka 2: ");
		
		Panel tacka1Panel = new Panel(new GridLayout(0, 1, 0, 1));
		Panel tacka2Panel = new Panel(new GridLayout(0, 1, 0, 1));
		
		tacka1Panel.add(tacka1Label);
		tacka2Panel.add(tacka2Label);
		
		//X1, Y1, Z1
		Label x1 = new Label("X1: ");
		TextField textFieldX1 = new TextField(10);
		
		Label y1 = new Label("Y1: ");
		TextField textFieldY1 = new TextField(10);
		
		Label z1 = new Label("Z1: ");
		TextField textFieldZ1 = new TextField(10);
		
		//X1
		Panel x1Panel = new Panel();
		x1Panel.add(x1);
		x1Panel.add(textFieldX1);
		
		tacka1Panel.add(x1Panel);
		
		//Y1
		Panel y1Panel = new Panel();
		y1Panel.add(y1);
		y1Panel.add(textFieldY1);
		
		tacka1Panel.add(y1Panel);
		
		//Z1
		Panel z1Panel = new Panel();
		z1Panel.add(z1);
		z1Panel.add(textFieldZ1);
		
		tacka1Panel.add(z1Panel);
		
		//X2, Y2, Z2
		Label x2 = new Label("X2: ");
		TextField textFieldX2 = new TextField(10);
		
		Label y2 = new Label("Y2: ");
		TextField textFieldY2 = new TextField(10);
		
		Label z2 = new Label("Z1: ");
		TextField textFieldZ2 = new TextField(10);
		
		//X2
		Panel x2Panel = new Panel();
		x2Panel.add(x2);
		x2Panel.add(textFieldX2);
				
		tacka2Panel.add(x2Panel);
				
		//Y2
		Panel y2Panel = new Panel();
		y2Panel.add(y2);
		y2Panel.add(textFieldY2);
		
		tacka2Panel.add(y2Panel);
		
		//Z2
		Panel z2Panel = new Panel();
		z2Panel.add(z2);
		z2Panel.add(textFieldZ2);
				
		tacka2Panel.add(z2Panel);
		
		//Button Rastojanje
		Button izracunaj = new Button("Izracunaj");
		Panel izracunajPanel = new Panel(new GridBagLayout());
		izracunaj.setBackground(Color.LIGHT_GRAY);
		izracunaj.setPreferredSize(new Dimension(200, 80));
		izracunajPanel.add(izracunaj, new GridBagConstraints());
		izracunajPanel.setBackground(Color.GREEN);
		
		//Ispis rastojanja
		Label rastojanje = new Label("Rastojanje: ");
		Label rastojanjeIzr = new Label("                          ");
		Panel rastojanjePanel = new Panel();
		rastojanjePanel.setBackground(Color.PINK);
		rastojanjePanel.add(rastojanje, BorderLayout.WEST);
		rastojanjePanel.add(rastojanjeIzr);
		
		
		izracunaj.addActionListener((ae) -> {
			try {
				double x1Vr = Double.parseDouble(textFieldX1.getText());
				double x2Vr = Double.parseDouble(textFieldX2.getText());
				double y1Vr = Double.parseDouble(textFieldY1.getText());
				double y2Vr = Double.parseDouble(textFieldY2.getText());
				double z1Vr = Double.parseDouble(textFieldZ1.getText());
				double z2Vr = Double.parseDouble(textFieldZ2.getText());
				
				double rastojanjeVr = Math.pow(Math.pow(x2Vr - x1Vr , 2) + 
										Math.pow(y2Vr - y1Vr , 2) +
										Math.pow(z2Vr - z1Vr , 2), 0.5);
				
				rastojanjeIzr.setText(Double.toString(rastojanjeVr));
				
			}catch(NumberFormatException e) {
				rastojanjeIzr.setText("Unesite brojeve!!");
			}
		});
		
		tacka1Panel.setBackground(Color.YELLOW);
		tacka2Panel.setBackground(Color.RED);
		zaTackePanel.add(tacka1Panel);
		zaTackePanel.add(tacka2Panel);
		tackeIDugmePanel.add(zaTackePanel);
		tackeIDugmePanel.add(izracunajPanel);
		//tackeIDugmePanel.add(rastojanjePanel);
		
		add(tackeIDugmePanel, BorderLayout.CENTER);
		add(rastojanjePanel, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		new Rastojanje2Tacke();
	}
}
