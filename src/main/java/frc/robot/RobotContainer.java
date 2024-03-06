// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import SOTAlib.Config.CompositeMotorConfig;
import SOTAlib.Config.ConfigUtils;
import SOTAlib.Config.EncoderConfig;
import SOTAlib.Config.MotorControllerConfig;
import SOTAlib.Encoder.Absolute.SOTA_AbsoulteEncoder;
import SOTAlib.Factories.CompositeMotorFactory;
import SOTAlib.Factories.MotorControllerFactory;
import SOTAlib.MotorController.SOTA_CompositeMotor;
import SOTAlib.MotorController.SOTA_MotorController;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.XboxController;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Command.ClimberClimb;
import frc.robot.SubSystems.AMP;
import frc.robot.SubSystems.Climber;
import frc.robot.SubSystems.Drive;
import frc.robot.SubSystems.Intake;
import frc.robot.SubSystems.Shooter;

public class RobotContainer {
  Drive mDrive;
  Shooter mShooter;
  Climber mClimber;
  CommandXboxController mXboxController;
  ConfigUtils mConfigUtils;
  AMP mAMP;
  Intake mIntake;
  
  

  public RobotContainer() {
    mConfigUtils = new ConfigUtils();
    // mXboxController = new XboxController(0);
    mXboxController = new CommandXboxController(0);
    
    
    

    try{
      //makes the motor controlers 
      MotorControllerConfig talonSRX_FeedWheelConfig = mConfigUtils.readFromClassPath(MotorControllerConfig.class, "TalonSRX_FeedWheel");
      SOTA_MotorController talonSRX_FeedWheel = MotorControllerFactory.generateMotorController(talonSRX_FeedWheelConfig);
      MotorControllerConfig talonSRXt_FlyWheelConfig = mConfigUtils.readFromClassPath(MotorControllerConfig.class, "TalonSRX_FlyWheel");
      SOTA_MotorController talonSRX_FlyWheel = MotorControllerFactory.generateMotorController(talonSRXt_FlyWheelConfig);
      
      mShooter = new Shooter(talonSRX_FeedWheel, talonSRX_FlyWheel);
      
    } catch (Exception e) {
      e.printStackTrace();
    }

    try{
      //makes the motor controlers
      MotorControllerConfig talonSRX_BackLeftDriveConfig = mConfigUtils.readFromClassPath(MotorControllerConfig.class, "TalonSRX_BackLeftDrive");
      SOTA_MotorController talonSRX_BackLeftDrive = MotorControllerFactory.generateMotorController(talonSRX_BackLeftDriveConfig);
      MotorControllerConfig talonSRX_BackRightDriveConfig = mConfigUtils.readFromClassPath(MotorControllerConfig.class, "TalonSRX_BackRightDrive");
      SOTA_MotorController talonSRX_BackRightDrive = MotorControllerFactory.generateMotorController(talonSRX_BackRightDriveConfig);
      MotorControllerConfig talonSRX_FrontLeftDriveConfig = mConfigUtils.readFromClassPath(MotorControllerConfig.class, "TalonSRX_FrontLeftDrive");
      SOTA_MotorController talonSRX_FrontLeftDrive = MotorControllerFactory.generateMotorController(talonSRX_FrontLeftDriveConfig);
      MotorControllerConfig talonSRX_FrontRightDriveConfig = mConfigUtils.readFromClassPath(MotorControllerConfig.class, "TalonSRX_FrontRightDrive");
      SOTA_MotorController talonSRX_FrontRightDrive = MotorControllerFactory.generateMotorController(talonSRX_FrontRightDriveConfig);

      mDrive = new Drive(talonSRX_BackLeftDrive, talonSRX_BackRightDrive, talonSRX_FrontLeftDrive, talonSRX_FrontRightDrive);
      

    } catch (Exception e) {
      e.printStackTrace();
    }

    try{
      //makes the motor controlers
      MotorControllerConfig talonSRX_ClimerWinchConfig = mConfigUtils.readFromClassPath(MotorControllerConfig.class, "TalonSRX_ClimerWinch");
      SOTA_MotorController talonSRX_ClimerWinch = MotorControllerFactory.generateMotorController(talonSRX_ClimerWinchConfig);

      DigitalInput limitSwitch = new DigitalInput(9);

      mClimber = new Climber(limitSwitch, talonSRX_ClimerWinch);
      
    } catch (Exception e) {
      e.printStackTrace();
    }

    
    try{
    //makes the motor controlers
    MotorControllerConfig talonSRX_AMPConfig = mConfigUtils.readFromClassPath(MotorControllerConfig.class, "TalonSRX_AMP");
    SOTA_MotorController talonSRX_AMP = MotorControllerFactory.generateMotorController(talonSRX_AMPConfig);

    mAMP = new AMP(talonSRX_AMP);
      

    } catch (Exception e) {
      e.printStackTrace();
    }


    try{
    //makes the motor controlers

      CompositeMotorFactory mCompositeMotorFactory = new CompositeMotorFactory();
      SOTA_CompositeMotor sparkMax_IntakeAngleCompositeMotor = mCompositeMotorFactory.generateCompositeMotor(mConfigUtils.readFromClassPath(CompositeMotorConfig.class, "SparkMax_IntakeAngle"));

      //MotorControllerConfig sparkMax_IntakeAngleConfig = mConfigUtils.readFromClassPath(MotorControllerConfig.class, "SparkMax_IntakeAngle");
      //SOTA_MotorController sparkMax_IntakeAngle = MotorControllerFactory.generateMotorController(sparkMax_IntakeAngleConfig);
      MotorControllerConfig sparkMax_IntakeIntakeConfig = mConfigUtils.readFromClassPath(MotorControllerConfig.class, "SparkMax_IntakeIntake");
      SOTA_MotorController sparkMax_IntakeIntake = MotorControllerFactory.generateMotorController(sparkMax_IntakeIntakeConfig);

      mIntake = new Intake(sparkMax_IntakeAngleCompositeMotor.getMotor(),sparkMax_IntakeIntake, sparkMax_IntakeAngleCompositeMotor.getAbsEncoder());
      

    } catch (Exception e) {
      e.printStackTrace();
    }



    
    configureBindings();
  }

  private void configureBindings() {
    mDrive.setDefaultCommand(Commands.run(() -> 
    mDrive.drive(mXboxController.getLeftY()*-1,mXboxController.getLeftX()*-1)
    ,mDrive));

    mIntake.setDefaultCommand(Commands.run(() -> 
    mIntake.intakeAngle(mXboxController.getRightY()*-1)
    ,mIntake));

    mXboxController.rightBumper().onTrue(Commands.run(() -> mIntake.intakeIntake(-1l), mIntake)).onFalse(Commands.runOnce(() -> mIntake.intakeIntake(0), mIntake));
    mXboxController.leftBumper().onTrue(Commands.run(() -> mIntake.intakeIntake(1), mIntake)).onFalse(Commands.runOnce(() -> mIntake.intakeIntake(0), mIntake));


    mXboxController.a().onTrue(Commands.run(() -> mShooter.shoot(1,1), mShooter)).onFalse(Commands.runOnce(() -> mShooter.shoot(0,0), mShooter));

    mXboxController.x().onTrue(Commands.run(() -> mAMP.moveAMP(1), mAMP)).onFalse(Commands.runOnce(() -> mAMP.moveAMP(0), mAMP));
    mXboxController.b().onTrue(Commands.run(() -> mAMP.moveAMP(-1), mAMP)).onFalse(Commands.runOnce(() -> mAMP.moveAMP(0), mAMP));

    mXboxController.y().onTrue(new ClimberClimb(mClimber));
    mXboxController.leftStick().onTrue(Commands.run(() -> mClimber.climb(-1), mClimber)).onFalse(Commands.runOnce(() -> mClimber.climb(0), mClimber));

  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }

  
}
