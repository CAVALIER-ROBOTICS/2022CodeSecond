// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimbSubsystem;

public class RaiseClimbCommand extends CommandBase {
  /** Creates a new RaiseCommand. */
  ClimbSubsystem climbSub;
  public RaiseClimbCommand(ClimbSubsystem c) {
    // Use addRequirements() here to declare subsystem dependencies.
    climbSub = c;
    addRequirements(c);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    climbSub.setClimb(1);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
    climbSub.setClimb(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
