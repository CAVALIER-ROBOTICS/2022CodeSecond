// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.BangBangController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSubsystem;

public class ShootCommand extends CommandBase {
  /** Creates a new ShootCommand. */
  ShooterSubsystem shootSub;
  BangBangController controller;
  double setpoint = 4000;
  double feed = 0.01;

  public ShootCommand(ShooterSubsystem s) {
    // Use addRequirements() here to declare subsystem dependencies.
    shootSub = s;
    controller = new BangBangController();
    addRequirements(s);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    shootSub.setKicker(0.5);
    shootSub.setShooter(controller.calculate(shootSub.getVolicty(), setpoint));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
    shootSub.setShooter(0);
    shootSub.setKicker(0);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
