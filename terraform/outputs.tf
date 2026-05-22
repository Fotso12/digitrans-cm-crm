output "ec2_public_ip" {
  description = "IP publique de l'instance EC2"
  value       = aws_instance.web.public_ip
}

output "database_endpoint" {
  description = "Endpoint (hôte et port) de la base de données RDS MySQL"
  value       = aws_db_instance.mysql.endpoint
}

output "backend_url" {
  description = "URL de base de l'API Backend Spring Boot"
  value       = "http://${aws_instance.web.public_ip}:8081"
}

output "frontend_url" {
  description = "URL de base de l'application Frontend Angular"
  value       = "http://${aws_instance.web.public_ip}"
}

output "frontend_login_url" {
  description = "URL de la page de Connexion (Login)"
  value       = "http://${aws_instance.web.public_ip}/auth/login"
}

output "frontend_register_url" {
  description = "URL de la page d'Inscription (Register)"
  value       = "http://${aws_instance.web.public_ip}/auth/register"
}

output "s3_bucket_name" {
  description = "Nom du bucket S3 créé"
  value       = aws_s3_bucket.app_storage.bucket
}
