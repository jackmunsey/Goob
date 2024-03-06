// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.SubSystems;

import SOTAlib.MotorController.SOTA_MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  private SOTA_MotorController talonSRX_FeedWheel;
  private SOTA_MotorController talonSRXt_FlyWheel;

  public Shooter(SOTA_MotorController talonSRX_FeedWheel, SOTA_MotorController talonSRXt_FlyWheel){
    this.talonSRX_FeedWheel = talonSRX_FeedWheel;
    this.talonSRXt_FlyWheel = talonSRXt_FlyWheel;
  }

  public void shoot(double feedWheelSpeed, double flyWheelSpeed){
    talonSRX_FeedWheel.set(feedWheelSpeed);
    talonSRXt_FlyWheel.set(flyWheelSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
