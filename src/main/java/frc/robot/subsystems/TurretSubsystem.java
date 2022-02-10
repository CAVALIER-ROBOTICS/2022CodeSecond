// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class TurretSubsystem extends SubsystemBase {
  /** Creates a new TurretSubsystem. */
  CANSparkMax turret = new CANSparkMax(Constants.turretID, MotorType.kBrushless);
  RelativeEncoder encoder = turret.getEncoder();

  boolean right = false;

  boolean left = false;
  
  public TurretSubsystem() 
  {
    encoder.setPosition(0);
  }

  public double getPos()
  {
    return encoder.getPosition();
  }

  public void setTurret(double volt)
  {
    turret.set(volt);
  }

  public void aim(double volt)
  {
    if(getPos()>2700&&!left)
    {
      right = true;
      setTurret(-0.01);
    }
    else if(getPos()<500&&!right)
    {
      left = true;
      setTurret(0.01);
    }

    if(right && getPos()<700)
    {
      right = false;
      setTurret(0);
    }

    if(left && getPos()>2500)
    {
      left = false;
      setTurret(0);
    }

    if(!right&&!left)
    {
      setTurret(volt);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Turret Enc", encoder.getPosition());
    SmartDashboard.putBoolean("right", right);
    SmartDashboard.putBoolean("Left", left);
  }
}
