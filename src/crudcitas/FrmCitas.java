package crudcitas;

import java.awt.GridLayout;
import javax.swing.*;
import util.Validaciones;

public class FrmCitas extends JFrame {
    private final CRUDCitas crud = new CRUDCitas();
    private final JTextField txtId = new JTextField();
    private final JTextField txtPaciente = new JTextField();
    private final JTextField txtDoctor = new JTextField();
    private final JTextField txtFecha = new JTextField();
    private final JTextField txtHora = new JTextField();
    private final JTextField txtMotivo = new JTextField();

    public FrmCitas() {
        setTitle("GESTIÓN DE CITAS MÉDICAS");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(520, 360);
        setLocationRelativeTo(null);
        setResizable(false);

        Validaciones.soloNumeros(txtId);
        Validaciones.soloNumeros(txtPaciente);
        Validaciones.soloNumeros(txtDoctor);
        Validaciones.fecha(txtFecha);
        Validaciones.hora(txtHora);
        Validaciones.soloLetras(txtMotivo);

        JPanel campos = new JPanel(new GridLayout(6, 2, 8, 8));
        campos.setBorder(BorderFactory.createEmptyBorder(18, 30, 10, 30));
        campos.add(new JLabel("N.º de cita:")); campos.add(txtId);
        campos.add(new JLabel("DNI paciente:")); campos.add(txtPaciente);
        campos.add(new JLabel("DNI doctor:")); campos.add(txtDoctor);
        campos.add(new JLabel("Fecha (dd/mm/aaaa):")); campos.add(txtFecha);
        campos.add(new JLabel("Hora (hh:mm):")); campos.add(txtHora);
        campos.add(new JLabel("Motivo:")); campos.add(txtMotivo);

        JPanel botones = new JPanel(new GridLayout(1, 4, 8, 8));
        JButton guardar = new JButton("Sacar cita");
        JButton buscar = new JButton("Buscar");
        JButton modificar = new JButton("Modificar");
        JButton eliminar = new JButton("Eliminar");
        botones.add(guardar); botones.add(buscar); botones.add(modificar); botones.add(eliminar);

        guardar.addActionListener(e -> guardar());
        buscar.addActionListener(e -> buscar());
        modificar.addActionListener(e -> modificar());
        eliminar.addActionListener(e -> eliminar());

        setLayout(new java.awt.BorderLayout());
        add(campos, java.awt.BorderLayout.CENTER);
        add(botones, java.awt.BorderLayout.SOUTH);
    }

    private boolean validar() {
        if (txtId.getText().trim().isEmpty() || txtPaciente.getText().trim().isEmpty() ||
            txtDoctor.getText().trim().isEmpty() || txtFecha.getText().trim().isEmpty() ||
            txtHora.getText().trim().isEmpty() || txtMotivo.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Complete todos los campos."); return false;
        }
        if (!txtFecha.getText().matches("\\d{2}/\\d{2}/\\d{4}")) {
            JOptionPane.showMessageDialog(this, "La fecha debe tener formato dd/mm/aaaa."); return false;
        }
        if (!txtHora.getText().matches("\\d{2}:\\d{2}")) {
            JOptionPane.showMessageDialog(this, "La hora debe tener formato hh:mm."); return false;
        }
        return true;
    }

    private void guardar() {
        if (!validar()) return;
        if (crud.agregar(new Cita(txtId.getText().trim(), txtPaciente.getText().trim(), txtDoctor.getText().trim(), txtFecha.getText().trim(), txtHora.getText().trim(), txtMotivo.getText().trim()))) {
            JOptionPane.showMessageDialog(this, "Cita registrada correctamente."); limpiar();
        } else JOptionPane.showMessageDialog(this, "Ese número de cita ya existe.");
    }

    private void buscar() {
        String id = txtId.getText().trim();
        if (id.isEmpty()) { JOptionPane.showMessageDialog(this, "Ingrese el número de cita."); return; }
        Cita c = crud.buscar(id);
        if (c == null) { JOptionPane.showMessageDialog(this, "Cita no encontrada."); return; }
        txtPaciente.setText(c.getDniPaciente()); txtDoctor.setText(c.getDniDoctor()); txtFecha.setText(c.getFecha()); txtHora.setText(c.getHora()); txtMotivo.setText(c.getMotivo());
    }

    private void modificar() {
        if (!validar()) return;
        if (crud.actualizar(txtId.getText().trim(), txtPaciente.getText().trim(), txtDoctor.getText().trim(), txtFecha.getText().trim(), txtHora.getText().trim(), txtMotivo.getText().trim())) {
            JOptionPane.showMessageDialog(this, "Cita modificada correctamente."); limpiar();
        } else JOptionPane.showMessageDialog(this, "Cita no encontrada.");
    }

    private void eliminar() {
        String id = txtId.getText().trim();
        if (id.isEmpty()) { JOptionPane.showMessageDialog(this, "Ingrese el número de cita."); return; }
        if (crud.eliminar(id)) { JOptionPane.showMessageDialog(this, "Cita eliminada correctamente."); limpiar(); }
        else JOptionPane.showMessageDialog(this, "Cita no encontrada.");
    }

    private void limpiar() { txtId.setText(""); txtPaciente.setText(""); txtDoctor.setText(""); txtFecha.setText(""); txtHora.setText(""); txtMotivo.setText(""); }
}
