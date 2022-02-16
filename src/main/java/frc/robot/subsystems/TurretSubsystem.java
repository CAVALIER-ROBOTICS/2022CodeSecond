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
  public int acceptedVolts = 30;

  boolean turningR;

  boolean turningL;
  
  public TurretSubsystem() 
  {
    // encoder.setPosition(0);
    turningR = false;
    turningL = false;
  }

  public double getPos()
  {
    return encoder.getPosition();
  }

  public double getVolt()
  {
    return turret.getOutputCurrent();
  }

  public void setTurret(double volt)
  {
    turret.set(volt);
    SmartDashboard.putNumber("volts", volt);

  }

  public void updateEnc()
  {
    encoder.setPosition(0);
  }

  public void aim(double temp)
  {
    double x = temp; 

    if(!turningR && !turningL)
    {
      setTurret(x);
    }

    if(getPos()<3)
    {
      turningR = true;
      x=0;
    }
    
    else if(getPos()>39)
    {
      turningL = true;
      x=0;
    }

    if(getPos()>36 && turningR)
    {
      turningR = false;
      x=0;
    }

    if(getPos()<6 && turningR)
    {
      turningL = false;
      x=0;
    }

    if(turningL)
    {
      temp = 0.0;
      setTurret(-.2);
    }
    else if(turningR)
    {
      temp = 0;
      setTurret(0.2);
    }
    // SmartDashboard.putNumber("PID volt", x);
    // SmartDashboard.putBoolean("turning left", turningL);
    // SmartDashboard.putBoolean("turning right", turningR);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Turret Enc", encoder.getPosition());
    // SmartDashboard.putBoolean("right", right);
    // SmartDashboard.putBoolean("Left", left);
  }
}
