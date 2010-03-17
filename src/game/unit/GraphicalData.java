package game.unit;

import game.main.Animation;

public class GraphicalData {
	//WMM = World Map Movement; BF = Battle Field
	private Animation WMMUp;
	private Animation WMMDown;
	private Animation WMMLeft;
	private Animation WMMRight;
	private Animation WMMUpRight;
	private Animation WMMUpLeft;
	private Animation WMMDownRight;
	private Animation WMMDownLeft;
	
	private Animation BFMovementLeft;
	private Animation BFMovementRight;
	private Animation BFStandLeft;
	private Animation BFStandRight;
	private Animation BFDieLeft;
	private Animation BFDieRight;
	private Animation BFAttackLeft;
	private Animation BFAttackRight;
	private Animation BFCastLeft;
	private Animation BFCastRight;
	
	public void setWorldMapMovementUp(Animation wMMUp) {
		WMMUp = wMMUp;
	}
	
	public Animation getWorldMapMovementUp() {
		return WMMUp;
	}
	
	public void setWorldMapMovementDown(Animation wMMDown) {
		WMMDown = wMMDown;
	}
	
	public Animation getWorldMapMovementDown() {
		return WMMDown;
	}
	
	public void setWorldMapMovementLeft(Animation wMMLeft) {
		WMMLeft = wMMLeft;
	}
	
	public Animation getWorldMapMovementLeft() {
		return WMMLeft;
	}
	
	public void setWorldMapMovementRight(Animation wMMRight) {
		WMMRight = wMMRight;
	}
	
	public Animation getWorldMapMovementRight() {
		return WMMRight;
	}
	
	public void setWorldMapMovementUpRight(Animation wMMUpRight) {
		WMMUpRight = wMMUpRight;
	}
	
	public Animation getWorldMapMovementUpRight() {
		return WMMUpRight;
	}
	
	public void setWorldMapMovementUpLeft(Animation wMMUpLeft) {
		WMMUpLeft = wMMUpLeft;
	}
	
	public Animation getWorldMapMovementUpLeft() {
		return WMMUpLeft;
	}
	
	public void setWorldMapMovementDownRight(Animation wMMDownRight) {
		WMMDownRight = wMMDownRight;
	}
	
	public Animation getWorldMapMovementDownRight() {
		return WMMDownRight;
	}
	
	public void setWorldMapMovementDownLeft(Animation wMMDownLeft) {
		WMMDownLeft = wMMDownLeft;
	}
	
	public Animation getWorldMapMovementDownLeft() {
		return WMMDownLeft;
	}
	
	public void setBattleFieldMovementLeft(Animation bFMovementLeft) {
		BFMovementLeft = bFMovementLeft;
	}
	
	public Animation getBattleFieldMovementLeft() {
		return BFMovementLeft;
	}
	
	public void setBattleFieldMovementRight(Animation bFMovementRight) {
		BFMovementRight = bFMovementRight;
	}
	
	public Animation getBattleFieldMovementRight() {
		return BFMovementRight;
	}
	
	public void setBattleFieldStandLeft(Animation bFStandLeft) {
		BFStandLeft = bFStandLeft;
	}
	
	public Animation getBattleFieldStandLeft() {
		return BFStandLeft;
	}
	
	public void setBattleFieldStandRight(Animation bFStandRight) {
		BFStandRight = bFStandRight;
	}
	
	public Animation getBattleFieldStandRight() {
		return BFStandRight;
	}
	
	public void setBattleFieldDieLeft(Animation bFDieLeft) {
		BFDieLeft = bFDieLeft;
	}
	
	public Animation getBattleFieldDieLeft() {
		return BFDieLeft;
	}
	
	public void setBattleFieldDieRight(Animation bFDieRight) {
		BFDieRight = bFDieRight;
	}
	
	public Animation getBattleFieldDieRight() {
		return BFDieRight;
	}
	
	public void setBattleFieldAttackLeft(Animation bFAttackLeft) {
		BFAttackLeft = bFAttackLeft;
	}
	
	public Animation getBattleFieldAttackLeft() {
		return BFAttackLeft;
	}
	
	public void setBattleFieldAttackRight(Animation bFAttackRight) {
		BFAttackRight = bFAttackRight;
	}
	
	public Animation getBattleFieldAttackRight() {
		return BFAttackRight;
	}
	
	public void setBattleFieldCastLeft(Animation bFCastLeft) {
		BFCastLeft = bFCastLeft;
	}
	
	public Animation getBattleFieldCastLeft() {
		return BFCastLeft;
	}
	
	public void setBattleFieldCastRight(Animation bFCastRight) {
		BFCastRight = bFCastRight;
	}
	
	public Animation getBattleFieldCastRight() {
		return BFCastRight;
	}
	
}
