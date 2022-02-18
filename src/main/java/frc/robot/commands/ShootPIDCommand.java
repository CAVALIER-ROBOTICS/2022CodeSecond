// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.LimelightSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class ShootPIDCommand extends PIDCommand {
  /** Creates a new ShootPIDCommand. */

  public ShootPIDCommand(ShooterSubsystem shootSub, LimelightSubsystem limeSub) {
    super(
        // The controller that the command will use
        new PIDController(0.1, 0.15, 0),
        // This should return the measurement
        () -> shootSub.getVolicty(),
        // This should return the setpoint (can also be a constant)
        () -> limeSub.getRPM(),
        // This uses the output
        output -> {
          shootSub.setShooter(output);
          // Use the output here
        });
    // Use addRequirements() here to declare subsystem dependencies.
    // Configure additional PID options by calling `getController` here.
    addRequirements(shootSub,limeSub);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
