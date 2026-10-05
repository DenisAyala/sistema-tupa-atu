package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VentanaPrincipalSSTE extends JFrame {

    private JTabbedPane pestanias;
    private DefaultTableModel modeloEmpresas, modeloVehiculos, modeloConductores, modeloExpedientes;

    public VentanaPrincipalSSTE() {
        setTitle("Sistema para la gestión de procedimientos Tupa - SGP");
        setSize(950, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Encabezado institucional
        JPanel pnlHeader = new JPanel(new BorderLayout());
        pnlHeader.setBackground(new Color(40, 40, 40));
        pnlHeader.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        JLabel lblTitulo = new JLabel("<html><font color='white' size='5'><b>Sistema para la gestión de procedimientos Tupa - SGP</b></font><br><font color='#CCCCCC' size='3'>Subdirección de Servicios de Transporte Especial y Servicios Complementarios - ATU</font></html>");
        JLabel lblUser = new JLabel("<html><font color='white'>Usuario: Administrador SSTE (admin)</font></html>");
        JButton btnCerrarSesion = new JButton("Cerrar sesión");

        JPanel pnlUserAcciones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnlUserAcciones.setOpaque(false);
        pnlUserAcciones.add(lblUser);
        pnlUserAcciones.add(btnCerrarSesion);

        pnlHeader.add(lblTitulo, BorderLayout.WEST);
        pnlHeader.add(pnlUserAcciones, BorderLayout.EAST);
        add(pnlHeader, BorderLayout.NORTH);

        // Barra de pestañas
        pestanias = new JTabbedPane();
        pestanias.addTab("1. Autorización de empresas", crearPanelEmpresas());
        pestanias.addTab("2. Habilitación vehicular", crearPanelVehiculos());
        pestanias.addTab("3. Habilitación de conductores", crearPanelConductores());
        pestanias.addTab("4. Consulta de trámites", crearPanelConsultas());
        add(pestanias, BorderLayout.CENTER);

        // Barra inferior de estado
        JPanel pnlFooter = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlFooter.setBackground(new Color(240, 240, 240));
        JLabel lblEstado = new JLabel(" Empresas autorizadas: 2  |  Vehículos habilitados: 1  |  Conductores habilitados: 1  |  Expedientes: 4");
        pnlFooter.add(lblEstado);
        add(pnlFooter, BorderLayout.SOUTH);
    }

    private JPanel crearPanelEmpresas() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel pnlFormularios = new JPanel(new GridLayout(1, 2, 10, 0));

        // Formulario Empresa
        JPanel pnlEmpresa = new JPanel(new GridLayout(7, 2, 5, 5));
        pnlEmpresa.setBorder(BorderFactory.createTitledBorder("Datos de la empresa"));
        JTextField txtRuc = new JTextField();
        JTextField txtRazonSocial = new JTextField();
        JTextField txtDireccion = new JTextField();
        JTextField txtDistrito = new JTextField();
        JTextField txtCorreo = new JTextField();
        JTextField txtTelefono = new JTextField();
        JComboBox<String> cboModalidad = new JComboBox<>(new String[]{"Transporte privado", "Taxi", "Escolar"});

        pnlEmpresa.add(new JLabel("RUC *:")); pnlEmpresa.add(txtRuc);
        pnlEmpresa.add(new JLabel("Razón social *:")); pnlEmpresa.add(txtRazonSocial);
        pnlEmpresa.add(new JLabel("Dirección *:")); pnlEmpresa.add(txtDireccion);
        pnlEmpresa.add(new JLabel("Distrito *:")); pnlEmpresa.add(txtDistrito);
        pnlEmpresa.add(new JLabel("Correo electrónico *:")); pnlEmpresa.add(txtCorreo);
        pnlEmpresa.add(new JLabel("Teléfono *:")); pnlEmpresa.add(txtTelefono);
        pnlEmpresa.add(new JLabel("Modalidad de servicio *:")); pnlEmpresa.add(cboModalidad);

        // Formulario Recibo
        JPanel pnlRecibo = new JPanel(new GridLayout(4, 2, 5, 5));
        pnlRecibo.setBorder(BorderFactory.createTitledBorder("Recibo de pago por derecho de trámite"));
        JTextField txtRecibo = new JTextField("R-001");
        JTextField txtMonto = new JTextField("150.00");
        JTextField txtFecha = new JTextField("04/10/2026");
        JComboBox<String> cboBanco = new JComboBox<>(new String[]{"BCP", "Banco de la Nación", "BBVA", "Interbank"});

        pnlRecibo.add(new JLabel("N.° de recibo *:")); pnlRecibo.add(txtRecibo);
        pnlRecibo.add(new JLabel("Monto (S/) *:")); pnlRecibo.add(txtMonto);
        pnlRecibo.add(new JLabel("Fecha de pago *:")); pnlRecibo.add(txtFecha);
        pnlRecibo.add(new JLabel("Entidad bancaria *:")); pnlRecibo.add(cboBanco);

        pnlFormularios.add(pnlEmpresa);
        pnlFormularios.add(pnlRecibo);

        // Botones
        JPanel pnlBotones = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnRegistrar = new JButton("Registrar y autorizar");
        btnRegistrar.setBackground(new Color(230, 150, 0));
        JButton btnLimpiar = new JButton("Limpiar");
        pnlBotones.add(btnRegistrar);
        pnlBotones.add(btnLimpiar);

        JPanel pnlSuperior = new JPanel(new BorderLayout());
        pnlSuperior.add(pnlFormularios, BorderLayout.CENTER);
        pnlSuperior.add(pnlBotones, BorderLayout.SOUTH);

        // Tabla
        String[] columnas = {"RUC", "Razón social", "Dirección", "Distrito", "Correo", "Teléfono", "Estado", "Veh. habil.", "Cond. habil."};
        modeloEmpresas = new DefaultTableModel(columnas, 0);
        modeloEmpresas.addRow(new Object[]{"20123456789", "Transportes Lima SAC", "Av. Arequipa 1234", "Lince", "contacto@tlima.pe", "014445566", "Autorizada", "0", "0"});
        modeloEmpresas.addRow(new Object[]{"20987654321", "Buses Callao SAC", "Av. Colonial 500", "Callao", "info@bcallao.pe", "015556677", "Autorizada", "0", "0"});
        JTable tbl = new JTable(modeloEmpresas);

        panel.add(pnlSuperior, BorderLayout.NORTH);
        panel.add(new JScrollPane(tbl), BorderLayout.CENTER);

        btnRegistrar.addActionListener((ActionEvent e) -> {
            if (txtRuc.getText().trim().isEmpty() || txtRazonSocial.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe completar el RUC y Razón Social.", "Validación", JOptionPane.WARNING_MESSAGE);
                return;
            }
            modeloEmpresas.addRow(new Object[]{txtRuc.getText().trim(), txtRazonSocial.getText().trim(), txtDireccion.getText().trim(), txtDistrito.getText().trim(), txtCorreo.getText().trim(), txtTelefono.getText().trim(), "Autorizada", "0", "0"});
            JOptionPane.showMessageDialog(this, "Empresa autorizada con éxito y expediente generado.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            txtRuc.setText(""); txtRazonSocial.setText(""); txtDireccion.setText(""); txtDistrito.setText(""); txtCorreo.setText(""); txtTelefono.setText("");
        });

        return panel;
    }

    private JPanel crearPanelVehiculos() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel pnlDatos = new JPanel(new GridLayout(6, 2, 5, 5));
        pnlDatos.setBorder(BorderFactory.createTitledBorder("Datos del vehículo"));
        JComboBox<String> cboEmpresa = new JComboBox<>(new String[]{"20123456789 - Transportes Lima SAC", "20987654321 - Buses Callao SAC"});
        JTextField txtPlaca = new JTextField();
        JTextField txtMarca = new JTextField();
        JTextField txtModelo = new JTextField();
        JComboBox<String> cboCategoria = new JComboBox<>(new String[]{"M1", "M2", "M3"});
        JTextField txtAnio = new JTextField();

        pnlDatos.add(new JLabel("Empresa autorizada *:")); pnlDatos.add(cboEmpresa);
        pnlDatos.add(new JLabel("Placa *:")); pnlDatos.add(txtPlaca);
        pnlDatos.add(new JLabel("Marca *:")); pnlDatos.add(txtMarca);
        pnlDatos.add(new JLabel("Modelo *:")); pnlDatos.add(txtModelo);
        pnlDatos.add(new JLabel("Categoría *:")); pnlDatos.add(cboCategoria);
        pnlDatos.add(new JLabel("Año de modelo *:")); pnlDatos.add(txtAnio);

        JPanel pnlBotones = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnHabilitar = new JButton("Habilitar vehículo");
        btnHabilitar.setBackground(new Color(230, 150, 0));
        JButton btnBaja = new JButton("Dar de baja");
        pnlBotones.add(btnHabilitar);
        pnlBotones.add(btnBaja);

        JPanel pnlNorte = new JPanel(new BorderLayout());
        pnlNorte.add(pnlDatos, BorderLayout.CENTER);
        pnlNorte.add(pnlBotones, BorderLayout.SOUTH);

        String[] cols = {"Placa", "Marca", "Modelo", "Categoría", "Año", "Antigüedad (años)", "Estado", "Empresa"};
        modeloVehiculos = new DefaultTableModel(cols, 0);
        modeloVehiculos.addRow(new Object[]{"ABC-123", "Toyota", "Hiace", "M2", "2022", "4", "Habilitado", "20123456789 - Transportes Lima SAC"});
        JTable tblVeh = new JTable(modeloVehiculos);

        panel.add(pnlNorte, BorderLayout.NORTH);
        panel.add(new JScrollPane(tblVeh), BorderLayout.CENTER);

        btnHabilitar.addActionListener(e -> {
            try {
                int anio = Integer.parseInt(txtAnio.getText().trim());
                if ((2026 - anio) > 15) {
                    JOptionPane.showMessageDialog(this, "El vehículo excede el límite máximo de 15 años de antigüedad.", "Regla Normativa ATU", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                modeloVehiculos.addRow(new Object[]{txtPlaca.getText().trim().toUpperCase(), txtMarca.getText().trim(), txtModelo.getText().trim(), cboCategoria.getSelectedItem(), anio, (2026 - anio), "Habilitado", cboEmpresa.getSelectedItem()});
                JOptionPane.showMessageDialog(this, "Vehículo habilitado e incorporado a la flota.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un año numérico válido.", "Error", JOptionPane.WARNING_MESSAGE);
            }
        });

        btnBaja.addActionListener(e -> {
            int fila = tblVeh.getSelectedRow();
            if (fila >= 0) {
                modeloVehiculos.setValueAt("Inactivo", fila, 6);
                JOptionPane.showMessageDialog(this, "Vehículo dado de baja.", "Baja Operativa", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un vehículo de la tabla.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        });

        return panel;
    }

    private JPanel crearPanelConductores() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel pnlDatos = new JPanel(new GridLayout(6, 2, 5, 5));
        pnlDatos.setBorder(BorderFactory.createTitledBorder("Datos del conductor"));
        JTextField txtDni = new JTextField();
        JTextField txtNombres = new JTextField();
        JTextField txtApellidos = new JTextField();
        JTextField txtLicencia = new JTextField();
        JComboBox<String> cboCat = new JComboBox<>(new String[]{"AI", "AII-a", "AII-b", "AIII-a", "AIII-b", "AIII-c"});
        JTextField txtVigencia = new JTextField("10/03/2029");

        pnlDatos.add(new JLabel("DNI *:")); pnlDatos.add(txtDni);
        pnlDatos.add(new JLabel("Nombres *:")); pnlDatos.add(txtNombres);
        pnlDatos.add(new JLabel("Apellidos *:")); pnlDatos.add(txtApellidos);
        pnlDatos.add(new JLabel("N.° de licencia *:")); pnlDatos.add(txtLicencia);
        pnlDatos.add(new JLabel("Categoría *:")); pnlDatos.add(cboCat);
        pnlDatos.add(new JLabel("Fecha vigencia *:")); pnlDatos.add(txtVigencia);

        JPanel pnlBotones = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnHabilitar = new JButton("Habilitar conductor");
        btnHabilitar.setBackground(new Color(230, 150, 0));
        JButton btnBaja = new JButton("Dar de baja");
        pnlBotones.add(btnHabilitar);
        pnlBotones.add(btnBaja);

        JPanel pnlNorte = new JPanel(new BorderLayout());
        pnlNorte.add(pnlDatos, BorderLayout.CENTER);
        pnlNorte.add(pnlBotones, BorderLayout.SOUTH);

        String[] cols = {"DNI", "Apellidos y nombres", "N.° licencia", "Categoría", "Vigencia", "Estado"};
        modeloConductores = new DefaultTableModel(cols, 0);
        modeloConductores.addRow(new Object[]{"45678912", "Gómez Rojas, Luis", "Q45678912", "AIII-a", "10/03/2029", "Habilitado"});
        JTable tblCond = new JTable(modeloConductores);

        panel.add(pnlNorte, BorderLayout.NORTH);
        panel.add(new JScrollPane(tblCond), BorderLayout.CENTER);

        btnHabilitar.addActionListener(e -> {
            String cat = (String) cboCat.getSelectedItem();
            if ("AI".equals(cat) || "AII-a".equals(cat)) {
                JOptionPane.showMessageDialog(this, "La categoría de licencia no cumple con el requisito mínimo (Mayor a AII-a).", "Normativa ATU", JOptionPane.ERROR_MESSAGE);
                return;
            }
            modeloConductores.addRow(new Object[]{txtDni.getText().trim(), txtApellidos.getText().trim() + ", " + txtNombres.getText().trim(), txtLicencia.getText().trim(), cat, txtVigencia.getText().trim(), "Habilitado"});
            JOptionPane.showMessageDialog(this, "Conductor habilitado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        });

        btnBaja.addActionListener(e -> {
            int fila = tblCond.getSelectedRow();
            if (fila >= 0) {
                modeloConductores.setValueAt("Inactivo", fila, 5);
                JOptionPane.showMessageDialog(this, "Conductor dado de baja.", "Baja Operativa", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un conductor de la tabla.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        });

        return panel;
    }

    private JPanel crearPanelConsultas() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel pnlBusqueda = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField txtBuscar = new JTextField(20);
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBackground(new Color(230, 150, 0));
        JButton btnTodos = new JButton("Ver todos");

        pnlBusqueda.add(new JLabel("RUC, placa o DNI:"));
        pnlBusqueda.add(txtBuscar);
        pnlBusqueda.add(btnBuscar);
        pnlBusqueda.add(btnTodos);

        String[] cols = {"N.° expediente", "Fecha y hora", "Tipo de trámite", "Estado", "RUC", "Razón social", "Placa / DNI", "Registrado por"};
        modeloExpedientes = new DefaultTableModel(cols, 0);
        modeloExpedientes.addRow(new Object[]{"EXP-2026-00004", "04/10/2026 14:00:00", "Habilitación de conductor", "Habilitado", "20123456789", "Transportes Lima SAC", "DNI: 45678912", "admin"});
        modeloExpedientes.addRow(new Object[]{"EXP-2026-00003", "04/10/2026 13:30:00", "Habilitación vehicular", "Habilitado", "20123456789", "Transportes Lima SAC", "Placa: ABC-123", "admin"});
        JTable tblExp = new JTable(modeloExpedientes);

        JTextArea txtDetalle = new JTextArea(6, 40);
        txtDetalle.setEditable(false);
        txtDetalle.setText("Detalle del expediente seleccionado:\nSeleccione un expediente de la tabla superior para consultar los datos completos.");

        JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, new JScrollPane(tblExp), new JScrollPane(txtDetalle));
        split.setDividerLocation(200);

        panel.add(pnlBusqueda, BorderLayout.NORTH);
        panel.add(split, BorderLayout.CENTER);

        tblExp.getSelectionModel().addListSelectionListener(e -> {
            int fila = tblExp.getSelectedRow();
            if (fila >= 0) {
                txtDetalle.setText("EXPEDIENTE: " + modeloExpedientes.getValueAt(fila, 0) +
                        "\nTrámite: " + modeloExpedientes.getValueAt(fila, 2) +
                        "\nEstado: " + modeloExpedientes.getValueAt(fila, 3) +
                        "\nEmpresa: " + modeloExpedientes.getValueAt(fila, 5) + " (RUC: " + modeloExpedientes.getValueAt(fila, 4) + ")" +
                        "\nAsociado: " + modeloExpedientes.getValueAt(fila, 6) +
                        "\nRegistrado por: " + modeloExpedientes.getValueAt(fila, 7));
            }
        });

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaPrincipalSSTE().setVisible(true);
        });
    }
}