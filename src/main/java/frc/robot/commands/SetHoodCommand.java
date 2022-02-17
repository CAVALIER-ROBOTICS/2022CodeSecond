// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.HoodSubsystem;
import frc.robot.subsystems.LimelightSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class SetHoodCommand extends PIDCommand {
  /** Creates a new SetHooderCommand. */
  public SetHoodCommand(HoodSubsystem hoodSub, LimelightSubsystem limeSub) {
    super(
        // The controller that the command will use
        new PIDController(0.001, 0.001, 0),
        // This should return the measurement
        () -> hoodSub.getPos(),
        // This should return the setpoint (can also be a constant)
        () -> hoodSub.getSetpoint(limeSub.getRPM(),limeSub.getDistance()),
        // This uses the output
        output -> {
          // Use the output here
          hoodSub.setHood(output);
        });
    // Use addRequirements() here to declare subsystem dependencies.
    // Configure additional PID options by calling `getController` here.
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
