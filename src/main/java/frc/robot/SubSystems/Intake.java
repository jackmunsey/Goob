// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.SubSystems;

import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkBase.ControlType;

import SOTAlib.Encoder.Absolute.SOTA_AbsoulteEncoder;
import SOTAlib.MotorController.SOTA_MotorController;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  CANSparkMax wrist;
  SOTA_MotorController intake;
  AbsoluteEncoder encoder;
  SparkPIDController pID;
  double setPoint;

  /** Creates a new Intake. */
  public Intake(CANSparkMax sparkMax_WristMotor, SOTA_MotorController sparkMax_IntakeIntake, AbsoluteEncoder sparkMax_WristAngleEncoder) {
    this.wrist = sparkMax_WristMotor;
    this.intake = sparkMax_IntakeIntake;
    this.encoder = sparkMax_WristAngleEncoder;
    pID = wrist.getPIDController();

    pID.setP(0);
    pID.setI(0);
    pID.setD(0);
    pID.setOutputRange(0, 0);
    pID.setFeedbackDevice(encoder);

    Shuffleboard.getTab("Intake").addNumber("Wrist Angle", encoder::getPosition);
    //Shuffleboard.getTab("Intake").addNumber("SetPoint", setPoint);
  }

  public void setSetPoint(double setPoint) {
    this.setPoint = setPoint;
  }

  public double getSetPoint(){
    return setPoint;
  }

  public void intakeIntake(double speed){
    intake.set(speed*.25);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    pID.setReference(setPoint, ControlType.kPosition);
  }
}
