// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.SubSystems;

import SOTAlib.MotorController.SOTA_MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class AMP extends SubsystemBase {
  private SOTA_MotorController talonSRX_AMP;
  /** Creates a new AMP. */
  public AMP(SOTA_MotorController talonSRX_AMP) {
    this.talonSRX_AMP = talonSRX_AMP;
  }

  public void moveAMP(double speed){
    talonSRX_AMP.set(speed*.3);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
