package game.unit;

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
