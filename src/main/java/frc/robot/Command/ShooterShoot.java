// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Command;

import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.SubSystems.Shooter;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class ShooterShoot extends SequentialCommandGroup {
  /** Creates a new ShooterShoot. */
  public ShooterShoot(Shooter mShooter) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new RunCommand(() -> {mShooter.shoot(0,1);;}, mShooter).withTimeout(.2),
      new RunCommand(() -> {mShooter.shoot(1,1);;}, mShooter).withTimeout(.2),
      new RunCommand(() -> {mShooter.shoot(0,0);;}, mShooter).withTimeout(.2)
    );
  }
}
