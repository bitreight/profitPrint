using System;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata;

namespace ProfitPrintCore.Models
{
    public partial class profit_print_dbContext : DbContext
    {
        public virtual DbSet<Customer> Customer { get; set; }
        public virtual DbSet<Executor> Executor { get; set; }
        public virtual DbSet<User> User { get; set; }
        public virtual DbSet<UserCredentials> UserCredentials { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            #warning To protect potentially sensitive information in your connection string, you should move it out of source code. See http://go.microsoft.com/fwlink/?LinkId=723263 for guidance on storing connection strings.
            optionsBuilder.UseMySql(@"Server=localhost;User Id=root;Password=meow;Database=profit_print_db");
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Customer>(entity =>
            {
                entity.ToTable("customer");

                entity.Property(e => e.Id)
                    .HasColumnName("ID")
                    .HasColumnType("bigint(20)");

                entity.Property(e => e.Fname)
                    .IsRequired()
                    .HasColumnName("FNAME")
                    .HasColumnType("varchar(255)");

                entity.Property(e => e.Lname)
                    .IsRequired()
                    .HasColumnName("LNAME")
                    .HasColumnType("varchar(255)");

                entity.HasOne(d => d.IdNavigation)
                    .WithOne(p => p.Customer)
                    .HasForeignKey<Customer>(d => d.Id)
                    .OnDelete(DeleteBehavior.Restrict)
                    .HasConstraintName("FK_CUSTOMER_USER_ID");
            });

            modelBuilder.Entity<Executor>(entity =>
            {
                entity.ToTable("executor");

                entity.Property(e => e.Id)
                    .HasColumnName("ID")
                    .HasColumnType("bigint(20)");

                entity.HasOne(d => d.IdNavigation)
                    .WithOne(p => p.Executor)
                    .HasForeignKey<Executor>(d => d.Id)
                    .OnDelete(DeleteBehavior.Restrict)
                    .HasConstraintName("FK_EXECUTOR_USER_ID");
            });

            modelBuilder.Entity<User>(entity =>
            {
                entity.ToTable("user");

                entity.Property(e => e.Id)
                    .HasColumnName("ID")
                    .HasColumnType("bigint(20)");

                entity.Property(e => e.Additional)
                    .HasColumnName("ADDITIONAL")
                    .HasColumnType("varchar(4000)");

                entity.Property(e => e.Phone)
                    .HasColumnName("PHONE")
                    .HasColumnType("varchar(255)");
            });

            modelBuilder.Entity<UserCredentials>(entity =>
            {
                entity.ToTable("user_credentials");

                entity.HasIndex(e => e.FkUserId)
                    .HasName("FK_USER_ID_UNIQUE")
                    .IsUnique();

                entity.HasIndex(e => e.Login)
                    .HasName("USERNAME_UNIQUE")
                    .IsUnique();

                entity.Property(e => e.Id)
                    .HasColumnName("ID")
                    .HasColumnType("bigint(20)");

                entity.Property(e => e.FkUserId)
                    .IsRequired()
                    .HasColumnName("FK_USER_ID")
                    .HasColumnType("bigint(20)");

                entity.Property(e => e.Login)
                    .IsRequired()
                    .HasColumnName("LOGIN")
                    .HasColumnType("varchar(255)");

                entity.Property(e => e.Password)
                    .IsRequired()
                    .HasColumnName("PASSWORD")
                    .HasColumnType("varchar(255)");

                entity.Property(e => e.Role)
                    .IsRequired()
                    .HasColumnName("ROLE")
                    .HasColumnType("varchar(255)");

                entity.HasOne(d => d.FkUser)
                    .WithOne(p => p.UserCredentials)
                    .HasForeignKey<UserCredentials>(d => d.FkUserId)
                    .OnDelete(DeleteBehavior.Restrict)
                    .HasConstraintName("FK_USER_CREDENTIALS_USER_ID");
            });
        }
    }
}