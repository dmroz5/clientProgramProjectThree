import javafx.scene.control.Button;

public class GameButton extends Button {
    private char color;
    private Boolean enabled;
    private int row;
    private int col;

    public GameButton(int row, int col) {
        this.row = row;
        this.col = col;
        this.enabled = false;
        // no color
        this.color = 'n';
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setColor(char color) {
        this.color = color;
    }

    public char getColor() {
        return color;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getEnabled() {
        return enabled;
    }
}
