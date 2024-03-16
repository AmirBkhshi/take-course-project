package view;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseMotionListener;

/**
 * @author oXCToo
 */
public class KGradientPanel extends JPanel
{

    public Color kStartColor = Color.MAGENTA;
    public Color kEndColor = Color.BLUE;
    public boolean kTransparentControls = true;
    public int kGradientFocus = 500;

    public Color getkStartColor()
    {
        return kStartColor;
    }

    public void setkStartColor(Color kStartColor)
    {
        this.kStartColor = kStartColor;
    }

    public Color getkEndColor()
    {
        return kEndColor;
    }

    public void setkEndColor(Color kEndColor)
    {
        this.kEndColor = kEndColor;
    }

    public boolean iskTransparentControls()
    {
        return kTransparentControls;
    }

    public void setkTransparentControls(boolean kTransparentControls)
    {
        this.kTransparentControls = kTransparentControls;
    }

    public int getkGradientFocus()
    {
        return kGradientFocus;
    }

    public void setkGradientFocus(int kGradientFocus)
    {
        this.kGradientFocus = kGradientFocus;
    }


    public KGradientPanel()
    {
        if (kTransparentControls)
        {
            setBg(true);
        }
        else
        {
            setBg(false);
        }
    }

    public KGradientPanel(Color kStartColor, Color kEndColor)
    {
        this();
        this.kStartColor = kStartColor;
        this.kEndColor = kEndColor;
    }

    @Override
    public synchronized void addMouseMotionListener(MouseMotionListener l)
    {
        super.addMouseMotionListener(l); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = getWidth();
        int h = getHeight();

        GradientPaint gp = new GradientPaint(0, 0, kStartColor, kGradientFocus, h, kEndColor);
        ;

        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
        //g2d.dispose();
    }

    private void setBg(boolean isOpaque)
    {
        Component[] components = this.getComponents();
        for (Component component : components)
        {

            ((JLabel) component).setOpaque(isOpaque);
            ((JCheckBox) component).setOpaque(isOpaque);
            ((JTextField) component).setOpaque(isOpaque);
            ((JPasswordField) component).setOpaque(isOpaque);
            ((JFormattedTextField) component).setOpaque(isOpaque);
            ((JToolBar) component).setOpaque(isOpaque);
            ((JRadioButton) component).setOpaque(isOpaque);

        }
    }

}