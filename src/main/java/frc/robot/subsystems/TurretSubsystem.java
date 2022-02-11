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

  boolean right = false;

  boolean left = false;
  
  public TurretSubsystem() 
  {
    // encoder.setPosition(0);
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
    //  if(volt>1||volt<-1) {
    //    SmartDashboard.putBoolean("itShit", true);
    //  }
    SmartDashboard.putNumber("volts", volt);

  }

  public void updateEnc()
  {
    encoder.setPosition(0);
  }

  public void aim(double x)
  {
    if(getPos()>2 && getPos()<40)
    {
      setTurret(x);
    }

    else if(getPos()<2)
    {
      while(getPos()<38)
      {
        setTurret(.2);
      }
      // setTurret(0);
    }
    else if(getPos()>40)
    {
      while(getPos()>4)
      {
        setTurret(-.2);
      }
      // setTurret(0);
    }
    SmartDashboard.putNumber("x", x);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    // SmartDashboard.putNumber("Turret Enc", encoder.getPosition());
    // SmartDashboard.putBoolean("right", right);
    // SmartDashboard.putBoolean("Left", left);
  }
}
