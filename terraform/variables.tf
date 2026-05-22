variable "aws_region" {
  description = "AWS Region to deploy resources"
  type        = string
  default     = "us-east-1"
}

variable "project_name" {
  description = "Project name tag"
  type        = string
  default     = "digitrans-crm"
}

variable "ec2_instance_type" {
  description = "EC2 instance type (Free Tier compliant)"
  type        = string
  default     = "t2.micro"
}

variable "db_name" {
  description = "Database name"
  type        = string
  default     = "crm_digitrans"
}

variable "db_username" {
  description = "Database master username"
  type        = string
  default     = "dbadmin"
}

variable "db_password" {
  description = "Database master password (sensitive)"
  type        = string
  default     = "dbpassword12345"
  sensitive   = true
}

variable "ssh_public_key" {
  description = "SSH public key for EC2 instance access"
  type        = string
  default     = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAICc16d5R1uG6u5NfX6h7j5oF8l8y8n5w8d8q8r8s8t8u digitrans-dummy-key" # Remplacer par sa propre clé publique
}
