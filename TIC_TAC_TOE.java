import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToeGame implements ActionListener {
JFrame frame = new JFrame("Tic Tac Toe");
JPanel panel = new JPanel();
JButton[] buttons = new JButton[9];
char currentPlayer = 'X';

public TicTacToeGame() {
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(400, 400);
panel.setLayout(new GridLayout(3, 3));
for (int i = 0; i < 9; i++) {
buttons[i] = new JButton("");
buttons[i].setFont(new Font("Arial", Font.PLAIN, 60));
buttons[i].setFocusable(false);
buttons[i].addActionListener(this);
panel.add(buttons[i]);
}
frame.add(panel);
frame.setVisible(true);
}

@Override
public void actionPerformed(ActionEvent e) {
JButton clickedButton = (JButton) e.getSource();
if (clickedButton.getText().equals("")) {
clickedButton.setText(String.valueOf(currentPlayer));
if (checkForWinner()) {
JOptionPane.showMessageDialog(frame, "Player " + currentPlayer + " wins!");
resetBoard();
} else if (isBoardFull()) {
JOptionPane.showMessageDialog(frame, "It's a draw!");
resetBoard();
} else {
currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
}
}
}

private boolean checkForWinner() {
// Check rows, columns, and diagonals for a win
for (int i = 0; i < 3; i++) {
if (buttons[i * 3].getText().equals(String.valueOf(currentPlayer)) &&
buttons[i * 3 + 1].getText().equals(String.valueOf(currentPlayer)) &&
buttons[i * 3 + 2].getText().equals(String.valueOf(currentPlayer))) {
return true;
}
if (buttons[i].getText().equals(String.valueOf(currentPlayer)) &&
buttons[i + 3].getText().equals(String.valueOf(currentPlayer)) &&
buttons[i + 6].getText().equals(String.valueOf(currentPlayer))) {
return true;
}
}
if (buttons[0].getText().equals(String.valueOf(currentPlayer)) &&
buttons[4].getText().equals(String.valueOf(currentPlayer)) &&
buttons[8].getText().equals(String.valueOf(currentPlayer))) {
return true;
}
if (buttons[2].getText().equals(String.valueOf(currentPlayer)) &&
buttons[4].getText().equals(String.valueOf(currentPlayer)) &&
buttons[6].getText().equals(String.valueOf(currentPlayer))) {
return true;
}
return false;
}

private boolean isBoardFull() {
for (JButton button : buttons) {
if (button.getText().equals("")) {
return false;
}
}
return true;
}

private void resetBoard() {
for (JButton button : buttons) {
button.setText("");
}
currentPlayer = 'X';
}

public static void main(String[] args) {
new TicTacToeGame();
}
}