package presentacion.vista;


import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Font;

public class VentanaPrincipal extends JFrame {

	private JMenuBar menuBar;
	private JMenu menuPersonas;
	private JMenuItem menuEliminar;
	private JMenuItem menuAgregar;
	private JMenuItem menuModificar;
	private JMenuItem menuListar;
	
	public VentanaPrincipal() {
		
		setTitle("Programa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 494);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menuPersonas = new JMenu("Personas");
		menuPersonas.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(menuPersonas);
		
		menuAgregar = new JMenuItem("Agregar");
		menuAgregar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuPersonas.add(menuAgregar);
		
		menuModificar = new JMenuItem("Modificar");
		menuModificar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuPersonas.add(menuModificar);
		
		menuEliminar = new JMenuItem("Eliminar");
		menuEliminar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuPersonas.add(menuEliminar);
		
		menuListar = new JMenuItem("Listar");
		menuListar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuPersonas.add(menuListar);
	}

	public JMenu getMenuPersonas() {
		return menuPersonas;
	}

	public void setMenuPersonas(JMenu menuPersonas) {
		this.menuPersonas = menuPersonas;
	}

	public JMenuItem getMenuAgregar() {
		return menuAgregar;
	}

	public void setMenuAgregar(JMenuItem menuAgregar) {
		this.menuAgregar = menuAgregar;
	}

	public JMenuItem getMenuModificar() {
		return menuModificar;
	}

	public void setMenuModificar(JMenuItem menuModificar) {
		this.menuModificar = menuModificar;
	}

	public JMenuItem getMenuEliminar() {
		return menuEliminar;
	}

	public void setMenuEliminar(JMenuItem menuEliminar) {
		this.menuEliminar = menuEliminar;
	}

	public JMenuItem getMenuListar() {
		return menuListar;
	}

	public void setMenuListar(JMenuItem menuListar) {
		this.menuListar = menuListar;
	}
	
}
