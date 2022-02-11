// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSubsystem;

public class KickCommand extends CommandBase {
  /** Creates a new KickCommand. */
  ShooterSubsystem shooterSub;

  public KickCommand(ShooterSubsystem k) {
    // Use addRequirements() here to declare subsystem dependencies.
    shooterSub = k;
    addRequirements(k);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    shooterSub.setKicker(0.8);
    shooterSub.setShooter(.7);
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
    shooterSub.setKicker(0);
    shooterSub.setShooter(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
