package game.unit;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import game.main.Animation;

public class GraphicalData {
	//WMM = World Map Movement; BF = Battle Field
	private Animation wMMUp;
	private Animation wMMDown;
	private Animation wMMLeft;
	private Animation wMMRight;
	private Animation wMMUpRight;
	private Animation wMMUpLeft;
	private Animation wMMDownRight;
	private Animation wMMDownLeft;
	
	private Animation wMMUpStand;
	private Animation wMMDownStand;
	private Animation wMMLeftStand;
	private Animation wMMRightStand;
	private Animation wMMUpRightStand;
	private Animation wMMUpLeftStand;
	private Animation wMMDownRightStand;
	private Animation wMMDownLeftStand;
	
	private Animation bFMovementLeft;
	private Animation bFMovementRight;
	private Animation bFStandLeft;
	private Animation bFStandRight;
	private Animation bFDieLeft;
	private Animation bFDieRight;
	private Animation bFAttackLeft;
	private Animation bFAttackRight;
	private Animation bFCastLeft;
	private Animation bFCastRight;
	
	private ArrayList<Animation> graphicalData = new ArrayList<Animation>();
	
	public GraphicalData() {
		
		long timeForScene = 30;
		
		wMMLeft = new Animation();
		
		Image buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/east/0151.png");
		wMMLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/east/0152.png");
		wMMLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/east/0153.png");
		wMMLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/east/0154.png");
		wMMLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/east/0155.png");
		wMMLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/east/0156.png");
		wMMLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/east/0157.png");
		wMMLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/east/0158.png");
		wMMLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/east/0159.png");
		wMMLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/east/0160.png");
		wMMLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/east/0161.png");
		wMMLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/east/0162.png");
		wMMLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/east/0163.png");
		wMMLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/east/0164.png");
		wMMLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/east/0165.png");
		wMMLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/east/0166.png");
		wMMLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/east/0167.png");
		wMMLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/east/0168.png");
		wMMLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/east/0169.png");
		wMMLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/east/0170.png");
		wMMLeft.addScene(buffer, timeForScene);
		
		wMMUp = new Animation();
		
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/north/0111.png");
		wMMUp.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/north/0112.png");
		wMMUp.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/north/0113.png");
		wMMUp.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/north/0114.png");
		wMMUp.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/north/0115.png");
		wMMUp.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/north/0116.png");
		wMMUp.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/north/0117.png");
		wMMUp.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/north/0118.png");
		wMMUp.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/north/0119.png");
		wMMUp.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/north/0120.png");
		wMMUp.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/north/0121.png");
		wMMUp.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/north/0122.png");
		wMMUp.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/north/0123.png");
		wMMUp.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/north/0124.png");
		wMMUp.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/north/0125.png");
		wMMUp.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/north/0126.png");
		wMMUp.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/north/0127.png");
		wMMUp.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/north/0128.png");
		wMMUp.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/north/0129.png");
		wMMUp.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/north/0130.png");
		wMMUp.addScene(buffer, timeForScene);
		
		wMMUpLeft = new Animation();
		
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northeast/0131.png");
		wMMUpLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northeast/0132.png");
		wMMUpLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northeast/0133.png");
		wMMUpLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northeast/0134.png");
		wMMUpLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northeast/0135.png");
		wMMUpLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northeast/0136.png");
		wMMUpLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northeast/0137.png");
		wMMUpLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northeast/0138.png");
		wMMUpLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northeast/0139.png");
		wMMUpLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northeast/0140.png");
		wMMUpLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northeast/0141.png");
		wMMUpLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northeast/0142.png");
		wMMUpLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northeast/0143.png");
		wMMUpLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northeast/0144.png");
		wMMUpLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northeast/0145.png");
		wMMUpLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northeast/0146.png");
		wMMUpLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northeast/0147.png");
		wMMUpLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northeast/0148.png");
		wMMUpLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northeast/0149.png");
		wMMUpLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northeast/0150.png");
		wMMUpLeft.addScene(buffer, timeForScene);
		
		wMMUpRight = new Animation();
		
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northwest/0091.png");
		wMMUpRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northwest/0092.png");
		wMMUpRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northwest/0093.png");
		wMMUpRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northwest/0094.png");
		wMMUpRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northwest/0095.png");
		wMMUpRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northwest/0096.png");
		wMMUpRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northwest/0097.png");
		wMMUpRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northwest/0098.png");
		wMMUpRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northwest/0099.png");
		wMMUpRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northwest/0100.png");
		wMMUpRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northwest/0101.png");
		wMMUpRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northwest/0102.png");
		wMMUpRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northwest/0103.png");
		wMMUpRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northwest/0104.png");
		wMMUpRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northwest/0105.png");
		wMMUpRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northwest/0106.png");
		wMMUpRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northwest/0107.png");
		wMMUpRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northwest/0108.png");
		wMMUpRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northwest/0109.png");
		wMMUpRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northwest/0110.png");
		wMMUpRight.addScene(buffer, timeForScene);
		
		wMMDown = new Animation();
		
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/south/0031.png");
		wMMDown.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/south/0032.png");
		wMMDown.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/south/0033.png");
		wMMDown.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/south/0034.png");
		wMMDown.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/south/0035.png");
		wMMDown.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/south/0036.png");
		wMMDown.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/south/0037.png");
		wMMDown.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/south/0038.png");
		wMMDown.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/south/0039.png");
		wMMDown.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/south/0040.png");
		wMMDown.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/south/0041.png");
		wMMDown.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/south/0042.png");
		wMMDown.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/south/0043.png");
		wMMDown.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/south/0044.png");
		wMMDown.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/south/0045.png");
		wMMDown.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/south/0046.png");
		wMMDown.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/south/0047.png");
		wMMDown.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/south/0048.png");
		wMMDown.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/south/0049.png");
		wMMDown.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/south/0050.png");
		wMMDown.addScene(buffer, timeForScene);
		
		wMMDownLeft = new Animation();
		
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/southwest/0051.png");
		wMMDownLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/southwest/0052.png");
		wMMDownLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/southwest/0053.png");
		wMMDownLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/southwest/0054.png");
		wMMDownLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/southwest/0055.png");
		wMMDownLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/southwest/0056.png");
		wMMDownLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/southwest/0057.png");
		wMMDownLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/southwest/0058.png");
		wMMDownLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/southwest/0059.png");
		wMMDownLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/southwest/0060.png");
		wMMDownLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/southwest/0061.png");
		wMMDownLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/southwest/0062.png");
		wMMDownLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/southwest/0063.png");
		wMMDownLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/southwest/0064.png");
		wMMDownLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/southwest/0065.png");
		wMMDownLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/southwest/0066.png");
		wMMDownLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/southwest/0067.png");
		wMMDownLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/southwest/0068.png");
		wMMDownLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/southwest/0069.png");
		wMMDownLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/southwest/0070.png");
		wMMDownLeft.addScene(buffer, timeForScene);
		
		wMMDownRight = new Animation();
		
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/southeast/0171.png");
		wMMDownRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/southeast/0172.png");
		wMMDownRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/southeast/0173.png");
		wMMDownRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/southeast/0174.png");
		wMMDownRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/southeast/0175.png");
		wMMDownRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/southeast/0176.png");
		wMMDownRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/southeast/0177.png");
		wMMDownRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/southeast/0178.png");
		wMMDownRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/southeast/0179.png");
		wMMDownRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/southeast/0180.png");
		wMMDownRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/southeast/0181.png");
		wMMDownRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/southeast/0182.png");
		wMMDownRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/southeast/0183.png");
		wMMDownRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/southeast/0184.png");
		wMMDownRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/southeast/0185.png");
		wMMDownRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/southeast/0186.png");
		wMMDownRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/southeast/0187.png");
		wMMDownRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/southeast/0188.png");
		wMMDownRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/southeast/0189.png");
		wMMDownRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/southeast/0190.png");
		wMMDownRight.addScene(buffer, timeForScene);
		
		wMMRight = new Animation();
		
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/west/0071.png");
		wMMRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/west/0072.png");
		wMMRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/west/0073.png");
		wMMRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/west/0074.png");
		wMMRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/west/0075.png");
		wMMRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/west/0076.png");
		wMMRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/west/0077.png");
		wMMRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/west/0078.png");
		wMMRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/west/0079.png");
		wMMRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/west/0080.png");
		wMMRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/west/0081.png");
		wMMRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/west/0082.png");
		wMMRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/west/0083.png");
		wMMRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/west/0084.png");
		wMMRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/west/0085.png");
		wMMRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/west/0086.png");
		wMMRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/west/0087.png");
		wMMRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/west/0088.png");
		wMMRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/west/0089.png");
		wMMRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/west/0090.png");
		wMMRight.addScene(buffer, timeForScene);
		
	}
	
	public void setWorldMapMovementUp(Animation wMMUp) {
		this.wMMUp = wMMUp;
	}
	
	public Animation getWorldMapMovementUp() {
		return wMMUp;
	}
	
	public void setWorldMapMovementDown(Animation wMMDown) {
		this.wMMDown = wMMDown;
	}
	
	public Animation getWorldMapMovementDown() {
		return wMMDown;
	}
	
	public void setWorldMapMovementLeft(Animation wMMLeft) {
		this.wMMLeft = wMMLeft;
	}
	
	public Animation getWorldMapMovementLeft() {
		return wMMLeft;
	}
	
	public void setWorldMapMovementRight(Animation wMMRight) {
		this.wMMRight = wMMRight;
	}
	
	public Animation getWorldMapMovementRight() {
		return wMMRight;
	}
	
	public void setWorldMapMovementUpRight(Animation wMMUpRight) {
		this.wMMUpRight = wMMUpRight;
	}
	
	public Animation getWorldMapMovementUpRight() {
		return wMMUpRight;
	}
	
	public void setWorldMapMovementUpLeft(Animation wMMUpLeft) {
		this.wMMUpLeft = wMMUpLeft;
	}
	
	public Animation getWorldMapMovementUpLeft() {
		return wMMUpLeft;
	}
	
	public void setWorldMapMovementDownRight(Animation wMMDownRight) {
		this.wMMDownRight = wMMDownRight;
	}
	
	public Animation getWorldMapMovementDownRight() {
		return wMMDownRight;
	}
	
	public void setWorldMapMovementDownLeft(Animation wMMDownLeft) {
		this.wMMDownLeft = wMMDownLeft;
	}
	
	public Animation getWorldMapMovementDownLeft() {
		return wMMDownLeft;
	}
	
	public Animation getwMMUpStand() {
		return wMMUpStand;
	}

	public void setwMMUpStand(Animation wMMUpStand) {
		this.wMMUpStand = wMMUpStand;
	}

	public Animation getwMMDownStand() {
		return wMMDownStand;
	}

	public void setwMMDownStand(Animation wMMDownStand) {
		this.wMMDownStand = wMMDownStand;
	}

	public Animation getwMMLeftStand() {
		return wMMLeftStand;
	}

	public void setwMMLeftStand(Animation wMMLeftStand) {
		this.wMMLeftStand = wMMLeftStand;
	}

	public Animation getwMMRightStand() {
		return wMMRightStand;
	}

	public void setwMMRightStand(Animation wMMRightStand) {
		this.wMMRightStand = wMMRightStand;
	}

	public Animation getwMMUpRightStand() {
		return wMMUpRightStand;
	}

	public void setwMMUpRightStand(Animation wMMUpRightStand) {
		this.wMMUpRightStand = wMMUpRightStand;
	}

	public Animation getwMMUpLeftStand() {
		return wMMUpLeftStand;
	}

	public void setwMMUpLeftStand(Animation wMMUpLeftStand) {
		this.wMMUpLeftStand = wMMUpLeftStand;
	}

	public Animation getwMMDownRightStand() {
		return wMMDownRightStand;
	}

	public void setwMMDownRightStand(Animation wMMDownRightStand) {
		this.wMMDownRightStand = wMMDownRightStand;
	}

	public Animation getwMMDownLeftStand() {
		return wMMDownLeftStand;
	}

	public void setwMMDownLeftStand(Animation wMMDownLeftStand) {
		this.wMMDownLeftStand = wMMDownLeftStand;
	}

	public void setBattleFieldMovementLeft(Animation bFMovementLeft) {
		this.bFMovementLeft = bFMovementLeft;
	}
	
	public Animation getBattleFieldMovementLeft() {
		return bFMovementLeft;
	}
	
	public void setBattleFieldMovementRight(Animation bFMovementRight) {
		this.bFMovementRight = bFMovementRight;
	}
	
	public Animation getBattleFieldMovementRight() {
		return bFMovementRight;
	}
	
	public void setBattleFieldStandLeft(Animation bFStandLeft) {
		this.bFStandLeft = bFStandLeft;
	}
	
	public Animation getBattleFieldStandLeft() {
		return bFStandLeft;
	}
	
	public void setBattleFieldStandRight(Animation bFStandRight) {
		this.bFStandRight = bFStandRight;
	}
	
	public Animation getBattleFieldStandRight() {
		return bFStandRight;
	}
	
	public void setBattleFieldDieLeft(Animation bFDieLeft) {
		this.bFDieLeft = bFDieLeft;
	}
	
	public Animation getBattleFieldDieLeft() {
		return bFDieLeft;
	}
	
	public void setBattleFieldDieRight(Animation bFDieRight) {
		this.bFDieRight = bFDieRight;
	}
	
	public Animation getBattleFieldDieRight() {
		return bFDieRight;
	}
	
	public void setBattleFieldAttackLeft(Animation bFAttackLeft) {
		this.bFAttackLeft = bFAttackLeft;
	}
	
	public Animation getBattleFieldAttackLeft() {
		return bFAttackLeft;
	}
	
	public void setBattleFieldAttackRight(Animation bFAttackRight) {
		this.bFAttackRight = bFAttackRight;
	}
	
	public Animation getBattleFieldAttackRight() {
		return bFAttackRight;
	}
	
	public void setBattleFieldCastLeft(Animation bFCastLeft) {
		this.bFCastLeft = bFCastLeft;
	}
	
	public Animation getBattleFieldCastLeft() {
		return bFCastLeft;
	}
	
	public void setBattleFieldCastRight(Animation bFCastRight) {
		this.bFCastRight = bFCastRight;
	}
	
	public Animation getBattleFieldCastRight() {
		return bFCastRight;
	}
	
	public ArrayList<Animation> getGraphicalData(){
		
		if(wMMUp!=null){
		graphicalData.add(wMMUp);
		}
		if(wMMDown!=null){
			graphicalData.add(wMMDown);
		}
		if(wMMLeft!=null){
			graphicalData.add(wMMLeft);
		}
		if(wMMRight!=null){
			graphicalData.add(wMMRight);
		}
		
		if(wMMUpLeft!=null){
			graphicalData.add(wMMUpLeft);
		}
		if(wMMDownRight!=null){
			graphicalData.add(wMMDownRight);
		}
		if(wMMDownLeft!=null){
			graphicalData.add(wMMDownLeft);
		}
		if(wMMUpRight!=null){
			graphicalData.add(wMMUpRight);
		}	
		
		
		if(bFAttackLeft!=null){
			graphicalData.add(bFAttackLeft);
		}	
		if(bFAttackRight!=null){
			graphicalData.add(bFAttackRight);
		}
		if(bFCastLeft!=null){
			graphicalData.add(bFCastLeft);
		}
		if(bFCastRight!=null){
			graphicalData.add(bFCastRight);
		}
		if(bFDieLeft!=null){
			graphicalData.add(bFDieLeft);
		}
		if(bFDieRight!=null){
			graphicalData.add(bFDieRight);
		}
		if(bFMovementLeft!=null){
			graphicalData.add(bFMovementLeft);
		}
		if(bFMovementRight!=null){
			graphicalData.add(bFMovementRight);
		}
		if(bFStandLeft!=null){
			graphicalData.add(bFStandLeft);
		}
		if(bFStandRight!=null){
			graphicalData.add(bFStandRight);
		}
		
		return graphicalData;		
	}
	
}
