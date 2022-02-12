// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

public class RaiseCommand extends CommandBase {
  /** Creates a new RaiseCommand. */
  IntakeSubsystem intakeSub;
  public RaiseCommand(IntakeSubsystem i) {
    // Use addRequirements() here to declare subsystem dependencies.
    intakeSub = i;
    addRequirements(i);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {
    intakeSub.setRaiseMotor(0.1);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
    intakeSub.setRaiseMotor(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    
    return false;
  }
}
