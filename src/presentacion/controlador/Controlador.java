package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import negocio.PersonaNegocio;
import presentacion.vista.PanelAgregarPersonas;
import presentacion.vista.PanelEliminarPersonas;
import presentacion.vista.PanelModificarPersonas;
import presentacion.vista.PanelListarPersonas;
import presentacion.vista.VentanaPrincipal;
import entidad.Persona;

public class Controlador implements ActionListener {

	private VentanaPrincipal ventanaPrincipal;
	private PersonaNegocio pNeg;
	private List<Persona> personasEnTabla;
	private DefaultListModel<Persona> listModel = new DefaultListModel<Persona>();
	private PanelAgregarPersonas pnlAgregarPersonas;
	private PanelEliminarPersonas pnlEliminarPersonas;
	private PanelModificarPersonas pnlModificarPersonas;
	private PanelListarPersonas pnlListarPersonas;

	// Constructor
	public Controlador(VentanaPrincipal vista, PersonaNegocio pNeg) {
		this.ventanaPrincipal = vista;
		this.pNeg = pNeg;

		// Instancio los paneles
		this.pnlAgregarPersonas = new PanelAgregarPersonas();
		this.pnlEliminarPersonas = new PanelEliminarPersonas();
		this.pnlModificarPersonas = new PanelModificarPersonas();
		this.pnlListarPersonas = new PanelListarPersonas();

		// Eventos menu del Frame principal llamado Ventana
		this.ventanaPrincipal.getMenuAgregar().addActionListener(a -> EventoClickMenu_AbrirPanel_AgregarPersona(a));
		this.ventanaPrincipal.getMenuEliminar().addActionListener(a -> EventoClickMenu_AbrirPanel_EliminarPersona(a));
		this.ventanaPrincipal.getMenuModificar().addActionListener(a -> EventoClickMenu_AbrirPanel_ModificarPersona(a));
		this.ventanaPrincipal.getMenuListar().addActionListener(a -> EventoClickMenu_AbrirPanel_ListarPersona(a));

		// Eventos click on Paneles
		this.pnlAgregarPersonas.getBtnAgregar()
				.addActionListener(a -> EventoClickButton_AgregarPesona_PanelAgregarPersonas(a));
		this.pnlModificarPersonas.getBtnModificar()
				.addActionListener(a -> EventoClickButton_ModificarPesona_PanelModificarPersonas(a));
		this.pnlModificarPersonas.getList()
				.addListSelectionListener(a -> EventoClickList_SeleccionarPesona_PanelModificarPersonas(a));
		this.pnlEliminarPersonas.getBtnEliminar()
				.addActionListener(a -> EventoClickButton_EliminarPesona_PanelEliminarPersonas(a));


	}

	// EVENTOS ABRIR PANELES

	// EventoClickMenu abrir PanelAgregarPersonas
	public void EventoClickMenu_AbrirPanel_AgregarPersona(ActionEvent a) {
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlAgregarPersonas);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}

	// EventoClickMenu abrir PanelEliminarPersonas
	public void EventoClickMenu_AbrirPanel_EliminarPersona(ActionEvent a) {
		ventanaPrincipal.getContentPane().removeAll();
		llenarDatos();
		pnlEliminarPersonas.setDefaultListModel(listModel);
		ventanaPrincipal.getContentPane().add(pnlEliminarPersonas);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}

	// EventoClickMenu abrir PanelModificarPersonas
	public void EventoClickMenu_AbrirPanel_ModificarPersona(ActionEvent a) {
		ventanaPrincipal.getContentPane().removeAll();
		llenarDatos();
		pnlModificarPersonas.setDefaultListModel(listModel);
		ventanaPrincipal.getContentPane().add(pnlModificarPersonas);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}

	public void EventoClickMenu_AbrirPanel_ListarPersona(ActionEvent a) {
		ventanaPrincipal.getContentPane().removeAll();
		this.pnlListarPersonas = new PanelListarPersonas();
		ventanaPrincipal.getContentPane().add(pnlListarPersonas);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}

	// EVENTOS CLICK BUTTON ON PANELS

	// EventoClickButton agregar persona en PanelAgregarPersonas
	private void EventoClickButton_AgregarPesona_PanelAgregarPersonas(ActionEvent a) {
		if(verificarCamposCompletos()){
			String nombre = this.pnlAgregarPersonas.getTxtNombre().getText();
			String apellido = this.pnlAgregarPersonas.getTxtApellido().getText();
			String dni = this.pnlAgregarPersonas.getTxtDNI().getText();
			Persona nuevaPersona = new Persona(dni, nombre, apellido);

			boolean estado = pNeg.insert(nuevaPersona);
			String mensaje;
			if (estado == true) {
				mensaje = "Persona agregada con exito";
				this.pnlAgregarPersonas.getTxtNombre().setText("");
				this.pnlAgregarPersonas.getTxtApellido().setText("");
				this.pnlAgregarPersonas.getTxtDNI().setText("");
			} else
				mensaje = "Ocurrió un error, la persona no ha sido agregada";

			this.pnlAgregarPersonas.mostrarMensaje(mensaje);
		} else
			this.pnlAgregarPersonas.mostrarMensaje("Todos los campos deben estar completos");
	}

	// EventoClickButton modificar persona en PanelModificarPersonas
	private void EventoClickButton_ModificarPesona_PanelModificarPersonas(ActionEvent a) {
		if (this.pnlModificarPersonas.getList().getSelectedIndex() >= 0) {
			String nombre = this.pnlModificarPersonas.getTxtNombre().getText();
			String apellido = this.pnlModificarPersonas.getTxtApellido().getText();
			String dni = this.pnlModificarPersonas.getTxtDni().getText();
			Persona nuevaPersona = new Persona(dni, nombre, apellido);

			boolean estado = pNeg.update(nuevaPersona);
			String mensaje;
			if (estado == true) {
				mensaje = "Persona modificada con exito";
				this.pnlModificarPersonas.getTxtNombre().setText("");
				this.pnlModificarPersonas.getTxtApellido().setText("");
				this.pnlModificarPersonas.getTxtDni().setText("");
			} else
				mensaje = "Ocurrió un error, la persona no ha sido modificada";

			this.pnlModificarPersonas.mostrarMensaje(mensaje);
			this.llenarDatos();
			pnlModificarPersonas.setDefaultListModel(listModel);
		} else
			this.pnlModificarPersonas.mostrarMensaje("Debe seleccionar una persona de la lista");
	}

	// EventoClickList seleccionar persona en PanelModificarPersonas
	private void EventoClickList_SeleccionarPesona_PanelModificarPersonas(ListSelectionEvent a) {
		int filaSeleccionada = this.pnlModificarPersonas.getList().getSelectedIndex();
		if (filaSeleccionada >= 0) {
			Persona personaSeleccionada = this.personasEnTabla.get(filaSeleccionada);
			this.pnlModificarPersonas.getTxtNombre().setText(personaSeleccionada.getNombre());
			this.pnlModificarPersonas.getTxtApellido().setText(personaSeleccionada.getApellido());
			this.pnlModificarPersonas.getTxtDni().setText(personaSeleccionada.getDni());
		}
	}

	// EventoClickButton eliminar persona en PanelEliminarPersonas
	private void EventoClickButton_EliminarPesona_PanelEliminarPersonas(ActionEvent a) {
		int filaSeleccionada = this.pnlEliminarPersonas.getList().getSelectedIndex();
		if (filaSeleccionada >= 0) {
			Persona personaSeleccionada = this.personasEnTabla.get(filaSeleccionada);
			String dni = personaSeleccionada.getDni();
			
			boolean estado = pNeg.delete(dni);
			String mensaje;
			if (estado)
				mensaje = "Persona eliminada con exito!";
			else 
				mensaje = "Ha ocurrido un error! La persona no fue eliminada.";
			
			this.pnlEliminarPersonas.mostrarMensaje(mensaje);
			this.llenarDatos();
		}
		else {
			this.pnlEliminarPersonas.mostrarMensaje("Debe seleccionar una persona!");
		}
	}
	

	private void refrescarTabla() {
		this.personasEnTabla = pNeg.readAll();
	}

	public void llenarDatos() {
		listModel.removeAllElements();
		refrescarTabla();

		if (!personasEnTabla.isEmpty()) {
			for (Persona p : personasEnTabla) {
				listModel.addElement(p);
			}
		}
	}

	public void inicializar() {
		this.ventanaPrincipal.setLocationRelativeTo(null);
		this.ventanaPrincipal.setVisible(true);
	}
	
	public boolean verificarCamposCompletos() {
		if(!this.pnlAgregarPersonas.getTxtDNI().getText().equals("") && !this.pnlAgregarPersonas.getTxtApellido().getText().equals("") && !this.pnlAgregarPersonas.getTxtNombre().getText().equals(""))
			return true;
		return false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

}
