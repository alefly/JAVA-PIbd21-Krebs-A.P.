package techProgr;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class Panelka extends JPanel implements DropTargetListener {

	private ITechnique ufo;

	public Panelka() {
		super();
		new DropTarget(this, this);
		this.setLayout(null);
		MagicLabel lblNewLabel = new MagicLabel("\u041E\u0441\u043D\u043E\u0432\u043D\u043E\u0439 \u0446\u0432\u0435\u0442", true, new IColor() {
					@Override
					public void setColor(Color c) {
						if (ufo != null) {
							ufo.setBodyColor(c);
						}
						repaint();
					}
				});
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(122, 146, 161, 27);
		lblNewLabel.setBorder(border);
		MagicLabel label_9 = new MagicLabel("\u0414\u043E\u043F\u043E\u043B\u043D\u0438\u0442\u0435\u043B\u044C\u043D\u044B\u0439 \u0446\u0432\u0435\u0442", true, new IColor() {
					@Override
					public void setColor(Color c) {
						if (ufo != null) {
							if (ufo instanceof BombUFO) {
								((BombUFO) ufo).setDopColor(c);
							}
						}
						repaint();
					}
				});
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setBounds(122, 184, 161, 27);
		label_9.setBorder(border);
		this.add(lblNewLabel);
		this.add(label_9);
	}

	public ITechnique getUFO() {
		return ufo;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (ufo != null) {
			ufo.setPosition(90, 65);
			ufo.drawUFO(g);
		}
	}

	@Override
	public void dragEnter(DropTargetDragEvent dtde) {

	}

	@Override
	public void dragExit(DropTargetEvent dte) {

	}

	@Override
	public void dragOver(DropTargetDragEvent dtde) {
	}

	@Override
	public void drop(DropTargetDropEvent dtde) {
		try {
			Transferable transferable = dtde.getTransferable();
			if (transferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {
				String dragContents = (String) transferable
						.getTransferData(DataFlavor.stringFlavor);
				if (dragContents.equals("SimpleUFO")) {
					ufo = new UFO(50, 5, 100, Color.black);
					repaint();
				} else if (dragContents.equals("MegaUFO")) {
					ufo = new BombUFO(50, 5, 100, Color.BLACK, true, true,
							Color.BLACK);
					repaint();
				} else {
					dtde.rejectDrop();
				}
			} else {
				dtde.rejectDrop();
			}
		} catch (IOException e) {
			dtde.rejectDrop();
		} catch (UnsupportedFlavorException e) {
			dtde.rejectDrop();
		}
	}

	@Override
	public void dropActionChanged(DropTargetDragEvent dtde) {

	}
}
