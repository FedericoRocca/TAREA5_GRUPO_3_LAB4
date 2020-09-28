package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

public class PanelAgregarPersonas extends JPanel {
	
	private JTextField textField_Apellido;
	private JTextField textField_DNI;
	private JTextField textField_Nombre;
	private JButton btnAceptar;
	
	public PanelAgregarPersonas() {
		super();
		initialize();
	}

	public void initialize() {
		
		this.setBounds(100, 100, 514, 455);
		setLayout(null);
		
		textField_Apellido = new JTextField();
		textField_Apellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Apellido.setBounds(240, 158, 157, 22);
		add(textField_Apellido);
		textField_Apellido.setColumns(10);
		
		textField_DNI = new JTextField();
		textField_DNI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_DNI.setBounds(240, 241, 157, 22);
		add(textField_DNI);
		textField_DNI.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(240, 327, 155, 25);
		add(btnAceptar);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(143, 84, 70, 19);
		add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblApellido.setBounds(143, 161, 70, 16);
		add(lblApellido);
		
		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDNI.setBounds(157, 244, 56, 16);
		add(lblDNI);
		
		textField_Nombre = new JTextField();
		textField_Nombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Nombre.setColumns(10);
		textField_Nombre.setBounds(240, 82, 157, 22);
		add(textField_Nombre);
	}
	
	public JButton getBtnAgregar() {
		return btnAceptar;
	}
	
	public JTextField getTxtApellido() {
		return textField_Apellido;
	}

	public void setTextField_Apellido(JTextField textField_Apellido) {
		this.textField_Apellido = textField_Apellido;
	}

	public JTextField getTxtDNI() {
		return textField_DNI;
	}

	public void setTextField_DNI(JTextField textField_DNI) {
		this.textField_DNI = textField_DNI;
	}

	public JTextField getTxtNombre() {
		return textField_Nombre;
	}

	public void setTextField_Nombre(JTextField textField_Nombre) {
		this.textField_Nombre = textField_Nombre;
	}


	public void show()
	{
		this.setVisible(true);
	}

	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}

}
