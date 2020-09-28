package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import entidad.Persona;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class PanelModificarPersonas extends JPanel {
	private JTextField txtNombre;
	private JTextField txtDni;
	private JLabel lblApellido;
	private JTextField txtApellido;
	private JButton btnModificar;
	private JList<Persona> list;
	private DefaultListModel<Persona> listModel;

	public PanelModificarPersonas() {
		setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(171, 303, 57, 20);
		add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(232, 300, 98, 26);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(39, 303, 30, 20);
		add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(69, 300, 87, 26);
		add(txtDni);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(343, 303, 70, 20);
		add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(405, 300, 98, 26);
		add(txtApellido);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(518, 293, 115, 41);
		add(btnModificar);
		
		list = new JList();
		list.setBounds(39, 40, 579, 240);
		add(list);
		
		JLabel lblModificar = new JLabel("Seleccione la persona a modificar:");
		lblModificar.setBounds(39, 16, 327, 20);
		add(lblModificar);
	}

	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	public JTextField getTxtNombre() {
		return txtNombre;
	}
	
	public JTextField getTxtApellido() {
		return txtApellido;
	}
	
	public JTextField getTxtDni() {
		return txtDni;
	}
	
	public JButton getBtnModificar() {
		return btnModificar;
	}
	
	public JList<Persona> getList() {
		return list;
	}

	public void setList(JList<Persona> list) {
		this.list = list;
	}
	
	public void setDefaultListModel(DefaultListModel<Persona> listModelRecibido) {
		this.listModel = listModelRecibido;
		list.setModel(this.listModel);
	}
	
}
