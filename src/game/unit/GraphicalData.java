package game.unit;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import game.main.Animation;

public class GraphicalData {
	//WMM = World Map Movement; BF = Battle Field
	//WMM sprites WIP
	private Animation wMMUp;
	private Animation wMMDown;
	private Animation wMMLeft;
	private Animation wMMRight;
	private Animation wMMUpLeft;
	private Animation wMMUpRight;
	private Animation wMMDownRight;
	private Animation wMMDownLeft;
	
	private Animation wMMUpStand;
	private Animation wMMDownStand;
	private Animation wMMLeftStand;
	private Animation wMMRightStand;
	private Animation wMMUpLeftStand;
	private Animation wMMUpRightStand;
	private Animation wMMDownRightStand;
	private Animation wMMDownLeftStand;
	
	// make setter and getter
//	private Animation BattleFieldMoveRight;
//	private Animation BattleFieldMoveLeft;
	private Animation BattleFieldStandRight;
	private Animation BattleFieldStandLeft;
	private Animation BfArcherMoveRight;
	private Animation BfArcherMoveLeft;
//	private Animation bFSwordmanMoveLeft;
//	private Animation bFSwordmanMoveRight;
//	private Animation bFMageMoveLeft;
//	private Animation bFMageMoveRight;
//	private Animation bFArcherStandLeft;
//	private Animation bFArcherStandRight;
//	private Animation bFSwordmanStandLeft;
//	private Animation bFSwordmanStandRight;
//	private Animation bFMageStandLeft;
//	private Animation bFMageStandRight;
//	private Animation bFArcherDieLeft;
//	private Animation bFArcherDieRight;
//	private Animation bFSwordmanDieLeft;
//	private Animation bFSwordmanDieRight;
//	private Animation bFMageDieLeft;
//	private Animation bFMageDieRight;
//	private Animation bFArcherAttackLeft;
//	private Animation bFArcherAttackRight;
//	private Animation bFSwordmanAttackLeft;
//	private Animation bFSwordmanAttackRight;
//	private Animation bFMageAttackLeft;
//	private Animation bFMageAttackRight;
//	private Animation bFMageCastLeft;
//	private Animation bFMAgeCastRight; 
//	
	private ArrayList<Animation> graphicalData = new ArrayList<Animation>();
	
	public GraphicalData() {
		
		long timeForScene = 200;
		
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
		
		wMMUpRight = new Animation();
		
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northeast/0131.png");
		wMMUpRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northeast/0132.png");
		wMMUpRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northeast/0133.png");
		wMMUpRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northeast/0134.png");
		wMMUpRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northeast/0135.png");
		wMMUpRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northeast/0136.png");
		wMMUpRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northeast/0137.png");
		wMMUpRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northeast/0138.png");
		wMMUpRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northeast/0139.png");
		wMMUpRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northeast/0140.png");
		wMMUpRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northeast/0141.png");
		wMMUpRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northeast/0142.png");
		wMMUpRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northeast/0143.png");
		wMMUpRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northeast/0144.png");
		wMMUpRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northeast/0145.png");
		wMMUpRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northeast/0146.png");
		wMMUpRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northeast/0147.png");
		wMMUpRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northeast/0148.png");
		wMMUpRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northeast/0149.png");
		wMMUpRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northeast/0150.png");
		wMMUpRight.addScene(buffer, timeForScene);
		
		wMMUpLeft = new Animation();
		
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northwest/0091.png");
		wMMUpLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northwest/0092.png");
		wMMUpLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northwest/0093.png");
		wMMUpLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northwest/0094.png");
		wMMUpLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northwest/0095.png");
		wMMUpLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northwest/0096.png");
		wMMUpLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northwest/0097.png");
		wMMUpLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northwest/0098.png");
		wMMUpLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northwest/0099.png");
		wMMUpLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northwest/0100.png");
		wMMUpLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northwest/0101.png");
		wMMUpLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northwest/0102.png");
		wMMUpLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northwest/0103.png");
		wMMUpLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northwest/0104.png");
		wMMUpLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northwest/0105.png");
		wMMUpLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northwest/0106.png");
		wMMUpLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northwest/0107.png");
		wMMUpLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northwest/0108.png");
		wMMUpLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northwest/0109.png");
		wMMUpLeft.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northwest/0110.png");
		wMMUpLeft.addScene(buffer, timeForScene);
		
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
		
		
		
		wMMRightStand = new Animation();
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/west/0071.png");
		wMMRightStand.addScene(buffer, timeForScene);
		
		wMMLeftStand = new Animation();
		
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/east/0151.png");
		wMMLeftStand.addScene(buffer, timeForScene);
		
		wMMUpStand = new Animation();
		
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/north/0111.png");
		wMMUpStand.addScene(buffer, timeForScene);
		
		wMMDownStand = new Animation();
		
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/south/0031.png");
		wMMDownStand.addScene(buffer, timeForScene);
		
		wMMUpRightStand = new Animation();
		
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northeast/0131.png");
		wMMUpRightStand.addScene(buffer, timeForScene);
		
		wMMUpLeftStand = new Animation();
		
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/northwest/0091.png");
		wMMUpLeftStand.addScene(buffer, timeForScene);
		
		wMMDownLeftStand = new Animation();
		
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/southwest/0051.png");
		wMMDownLeftStand.addScene(buffer, timeForScene);
		
		wMMDownRightStand = new Animation();
		
		buffer = Toolkit.getDefaultToolkit().getImage("Images/units/human/hero/world/southeast/0171.png");
		wMMDownRightStand.addScene(buffer, timeForScene);
		
		
		BfArcherMoveRight = new Animation();
		
		buffer = Toolkit.getDefaultToolkit().getImage("Images/bf/archer/move/right/0006.png");
		BfArcherMoveRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/bf/archer/move/right/0007.png");
		BfArcherMoveRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/bf/archer/move/right/0008.png");
		BfArcherMoveRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/bf/archer/move/right/0009.png");
		BfArcherMoveRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/bf/archer/move/right/0010.png");
		BfArcherMoveRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/bf/archer/move/right/0011.png");
		BfArcherMoveRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/bf/archer/move/right/0012.png");
		BfArcherMoveRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/bf/archer/move/right/0013.png");
		BfArcherMoveRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/bf/archer/move/right/0014.png");
		BfArcherMoveRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/bf/archer/move/right/0015.png");
		BfArcherMoveRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/bf/archer/move/right/0016.png");
		BfArcherMoveRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/bf/archer/move/right/0017.png");
		BfArcherMoveRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/bf/archer/move/right/0018.png");
		BfArcherMoveRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/bf/archer/move/right/0019.png");
		BfArcherMoveRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/bf/archer/move/right/0020.png");
		BfArcherMoveRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/bf/archer/move/right/0021.png");
		BfArcherMoveRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/bf/archer/move/right/0022.png");
		BfArcherMoveRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/bf/archer/move/right/0023.png");
		BfArcherMoveRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/bf/archer/move/right/0024.png");
		BfArcherMoveRight.addScene(buffer, timeForScene);
		buffer = Toolkit.getDefaultToolkit().getImage("Images/bf/archer/move/right/0025.png");
		BfArcherMoveRight.addScene(buffer, timeForScene);
		
		
		
		
		getGraphicalData();
		
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
		this.wMMUpLeft = wMMUpRight;
	}
	
	public Animation getWorldMapMovementUpRight() {
		return wMMUpLeft;
	}
	
	public void setWorldMapMovementUpLeft(Animation wMMUpLeft) {
		this.wMMUpRight = wMMUpLeft;
	}
	
	public Animation getWorldMapMovementUpLeft() {
		return wMMUpRight;
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
		return wMMUpLeftStand;
	}

	public void setwMMUpRightStand(Animation wMMUpRightStand) {
		this.wMMUpLeftStand = wMMUpRightStand;
	}

	public Animation getwMMUpLeftStand() {
		return wMMUpRightStand;
	}

	public void setwMMUpLeftStand(Animation wMMUpLeftStand) {
		this.wMMUpRightStand = wMMUpLeftStand;
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
		
		if(wMMUpRight!=null){
			graphicalData.add(wMMUpRight);
		}
		if(wMMDownRight!=null){
			graphicalData.add(wMMDownRight);
		}
		if(wMMDownLeft!=null){
			graphicalData.add(wMMDownLeft);
		}
		if(wMMUpLeft!=null){
			graphicalData.add(wMMUpLeft);
		}	
		if(BfArcherMoveRight!=null){
			graphicalData.add(BfArcherMoveLeft);
		}
		if(BfArcherMoveRight!=null){
			graphicalData.add(BfArcherMoveRight);
		}
			
		return graphicalData;		
	}

	public void setBattleFieldStandRight(Animation battleFieldStandRight) {
		BattleFieldStandRight = battleFieldStandRight;
	}

	public Animation getBattleFieldStandRight() {
		return BattleFieldStandRight;
	}

	public void setBattleFieldStandLeft(Animation battleFieldStandLeft) {
		BattleFieldStandLeft = battleFieldStandLeft;
	}

	public Animation getBattleFieldStandLeft() {
		return BattleFieldStandLeft;
	}
	
}
