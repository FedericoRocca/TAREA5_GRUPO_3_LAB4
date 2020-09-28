package presentacion.vista;

import javax.swing.JPanel;


import entidad.Persona;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.util.List;

public class PanelEliminarPersonas extends JPanel {

	private JButton btnEliminar;
	private JList<Persona> list;
	private DefaultListModel<Persona> listModel;
	
	public PanelEliminarPersonas() {
		setLayout(null);
		this.setBounds(100, 100, 514, 455);
		
		JLabel lblEliminarUsu = new JLabel("Eliminar Usuarios");
		lblEliminarUsu.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEliminarUsu.setBounds(182, 33, 123, 16);
		add(lblEliminarUsu);
		
		list = new JList<Persona>();
		list.setFont(new Font("Tahoma", Font.PLAIN, 14));
		list.setBounds(65, 89, 389, 240);
		add(list);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(192, 363, 97, 25);
		add(btnEliminar);
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

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
}
