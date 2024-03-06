// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.SubSystems;

import SOTAlib.Encoder.Absolute.SOTA_AbsoulteEncoder;
import SOTAlib.MotorController.SOTA_MotorController;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  SOTA_MotorController sparkMax_IntakeAngle;
  SOTA_MotorController sparkMax_IntakeIntake;
  SOTA_AbsoulteEncoder sparkMax_IntakeAngleEncoder;

  /** Creates a new Intake. */
  public Intake(SOTA_MotorController sparkMax_IntakeAngle, SOTA_MotorController sparkMax_IntakeIntake, SOTA_AbsoulteEncoder sparkMax_IntakeAngleEncoder) {
    this.sparkMax_IntakeAngle = sparkMax_IntakeAngle;
    this.sparkMax_IntakeIntake = sparkMax_IntakeIntake;
    this.sparkMax_IntakeAngleEncoder = sparkMax_IntakeAngleEncoder;
    Shuffleboard.getTab("Intake").addNumber("Wrist Angle", sparkMax_IntakeAngleEncoder::getPosition);
    Shuffleboard.getTab("Intake").addNumber("Integrated wrists encoder", sparkMax_IntakeAngle::getEncoderPosition);
  }

  public void intakeAngle(double speed) {
    sparkMax_IntakeAngle.set(speed*.35);
  }

  public void intakeIntake(double speed){
    sparkMax_IntakeIntake.set(speed*.25);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Encoder Position", sparkMax_IntakeAngleEncoder.getPosition());
    // This method will be called once per scheduler run
  }
}
