// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.SubSystems;

import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkBase.IdleMode;

import SOTAlib.Encoder.Absolute.SOTA_AbsoulteEncoder;
import SOTAlib.MotorController.SOTA_MotorController;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {

  SOTA_MotorController intake;
  

  /** Creates a new Intake. */
  public Intake(SOTA_MotorController sparkMax_IntakeIntake) {
    this.intake = sparkMax_IntakeIntake;

  }
  public void intakeIntake(double speed){
    intake.set(speed*.4);
  }

  @Override
  public void periodic() {
    
    //SmartDashboard.putNumber("Encoder Position", sparkMax_IntakeAngleEncoder.getPosition());
    // This method will be called once per scheduler run
  }
}
