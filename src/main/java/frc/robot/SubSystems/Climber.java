// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.SubSystems;

import SOTAlib.MotorController.SOTA_MotorController;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climber extends SubsystemBase {
  private DigitalInput limitSwitch;
  private SOTA_MotorController talonSRX_ClimerWinch;

  /** Creates a new Climber. */
  public Climber(DigitalInput limitSwitch, SOTA_MotorController talonSRX_ClimerWinch) {
    this.limitSwitch = limitSwitch;
    this.talonSRX_ClimerWinch = talonSRX_ClimerWinch;
  }

  public void climb(double climingSpeed){
    talonSRX_ClimerWinch.set(climingSpeed*.3);
  }

  public boolean getLimitSwitch(){
    return limitSwitch.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
  }
}
