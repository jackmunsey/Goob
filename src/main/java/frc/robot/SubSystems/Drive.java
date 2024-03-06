// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.SubSystems;

import SOTAlib.MotorController.SOTA_MotorController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {
  private SOTA_MotorController talonSRX_BackLeftDrive;
  private SOTA_MotorController talonSRX_BackRightDrive;
  private SOTA_MotorController talonSRX_FrontLeftDrive;
  private SOTA_MotorController talonSRX_FrontRightDrive;
  private DifferentialDrive diffDrive;

  public Drive(SOTA_MotorController talonSRX_BackLeftDrive, SOTA_MotorController talonSRX_BackRightDrive, SOTA_MotorController talonSRX_FrontLeftDrive, SOTA_MotorController talonSRX_FrontRightDrive){
    this.talonSRX_BackLeftDrive = talonSRX_BackLeftDrive;
    this.talonSRX_BackRightDrive = talonSRX_BackRightDrive;
    this.talonSRX_FrontLeftDrive = talonSRX_FrontLeftDrive;
    this.talonSRX_FrontRightDrive = talonSRX_FrontRightDrive;

    MotorControllerGroup leftMotors = new MotorControllerGroup(talonSRX_BackLeftDrive, talonSRX_FrontLeftDrive);
    MotorControllerGroup rightMotors = new MotorControllerGroup(talonSRX_BackRightDrive, talonSRX_FrontRightDrive);

    diffDrive = new DifferentialDrive(leftMotors, rightMotors);
  }

  public void drive(double fwd, double rot) {
    diffDrive.arcadeDrive(fwd*.8,rot*.6);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
