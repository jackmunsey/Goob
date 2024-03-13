// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.SubSystems;

import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkPIDController;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Wrist extends SubsystemBase {
  CANSparkMax wrist;
  AbsoluteEncoder encoder;
  SparkPIDController pID;
  double setPoint = 0.03;
  /** Creates a new wrist. */

  public Wrist(CANSparkMax wrist, AbsoluteEncoder encoder) {

    this.wrist = wrist;
    this.encoder = encoder;
    pID = wrist.getPIDController();
    wrist.setIdleMode(IdleMode.kBrake);
    wrist.setInverted(true);
    pID.setP(2);
    pID.setI(0);
    pID.setD(0);
    pID.setOutputRange(-2, 2);
    pID.setFeedbackDevice(encoder);
  }

  public void setSetPoint(double setPoint){
    this.setPoint = setPoint;
  }

  @Override
  public void periodic() {
    pID.setReference(setPoint, com.revrobotics.CANSparkBase.ControlType.kPosition);
    // This method will be called once per scheduler run
  }
}
