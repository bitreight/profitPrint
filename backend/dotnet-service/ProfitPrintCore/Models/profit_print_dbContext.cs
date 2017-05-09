using System;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata;

namespace ProfitPrintCore.Models
{
    public partial class profit_print_dbContext : DbContext
    {
        public virtual DbSet<Customer> Customer { get; set; }
        public virtual DbSet<Executor> Executor { get; set; }
        public virtual DbSet<Registerkey> Registerkey { get; set; }
        public virtual DbSet<SchemaVersion> SchemaVersion { get; set; }
        public virtual DbSet<User> User { get; set; }
        public virtual DbSet<Usercredentials> Usercredentials { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            optionsBuilder.UseMySql(@"Server=localhost;User Id=profit-print;Password=profit-pass;Database=profit_print_db");
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Customer>(entity =>
            {
                entity.ToTable("customer");

                entity.Property(e => e.Id)
                    .HasColumnName("ID")
                    .HasColumnType("bigint(20)");

                entity.Property(e => e.FirstName).HasColumnType("varchar(255)");

                entity.Property(e => e.LastName).HasColumnType("varchar(255)");

                entity.HasOne(d => d.IdNavigation)
                    .WithOne(p => p.Customer)
                    .HasForeignKey<Customer>(d => d.Id)
                    .OnDelete(DeleteBehavior.Restrict)
                    .HasConstraintName("FKgws7qc0vrq8ohllfbrtfa6co9");
            });

            modelBuilder.Entity<Executor>(entity =>
            {
                entity.ToTable("executor");

                entity.Property(e => e.Id)
                    .HasColumnName("ID")
                    .HasColumnType("bigint(20)");

                entity.Property(e => e.Address)
                    .IsRequired()
                    .HasColumnType("varchar(255)");

                entity.Property(e => e.CloseTime).HasColumnType("time");

                entity.Property(e => e.OpenTime).HasColumnType("time");

                entity.Property(e => e.WebSite).HasColumnType("varchar(255)");

                entity.HasOne(d => d.IdNavigation)
                    .WithOne(p => p.Executor)
                    .HasForeignKey<Executor>(d => d.Id)
                    .OnDelete(DeleteBehavior.Restrict)
                    .HasConstraintName("FKkf2n18qxbyqiexx649hbm548m");
            });

            modelBuilder.Entity<Registerkey>(entity =>
            {
                entity.ToTable("registerkey");

                entity.HasIndex(e => e.ExecutorId)
                    .HasName("UK_ha8d0goy2mqd5lv9tqtnsdpu3")
                    .IsUnique();

                entity.Property(e => e.Id)
                    .HasColumnName("ID")
                    .HasColumnType("bigint(20)");

                entity.Property(e => e.ExecutorId)
                    .IsRequired()
                    .HasColumnType("bigint(20)");

                entity.Property(e => e.Value)
                    .IsRequired()
                    .HasColumnName("value")
                    .HasColumnType("varchar(255)");

                entity.HasOne(d => d.Executor)
                    .WithOne(p => p.Registerkey)
                    .HasForeignKey<Registerkey>(d => d.ExecutorId)
                    .OnDelete(DeleteBehavior.Restrict)
                    .HasConstraintName("FKsspwwh6sdg0642phorpt1m4m1");
            });

            modelBuilder.Entity<SchemaVersion>(entity =>
            {
                entity.HasKey(e => e.InstalledRank)
                    .HasName("PK_schema_version");

                entity.ToTable("schema_version");

                entity.HasIndex(e => e.Success)
                    .HasName("schema_version_s_idx");

                entity.Property(e => e.InstalledRank)
                    .HasColumnName("installed_rank")
                    .HasColumnType("int(11)");

                entity.Property(e => e.Checksum)
                    .HasColumnName("checksum")
                    .HasColumnType("int(11)");

                entity.Property(e => e.Description)
                    .IsRequired()
                    .HasColumnName("description")
                    .HasColumnType("varchar(200)");

                entity.Property(e => e.ExecutionTime)
                    .HasColumnName("execution_time")
                    .HasColumnType("int(11)");

                entity.Property(e => e.InstalledBy)
                    .IsRequired()
                    .HasColumnName("installed_by")
                    .HasColumnType("varchar(100)");

                entity.Property(e => e.Script)
                    .IsRequired()
                    .HasColumnName("script")
                    .HasColumnType("varchar(1000)");

                entity.Property(e => e.Success)
                    .HasColumnName("success")
                    .HasColumnType("tinyint(1)");

                entity.Property(e => e.Type)
                    .IsRequired()
                    .HasColumnName("type")
                    .HasColumnType("varchar(20)");

                entity.Property(e => e.Version)
                    .HasColumnName("version")
                    .HasColumnType("varchar(50)");
            });

            modelBuilder.Entity<User>(entity =>
            {
                entity.ToTable("user");

                entity.Property(e => e.Id)
                    .HasColumnName("ID")
                    .HasColumnType("bigint(20)");

                entity.Property(e => e.Email).HasColumnType("varchar(255)");

                entity.Property(e => e.Phone).HasColumnType("varchar(255)");
            });

            modelBuilder.Entity<Usercredentials>(entity =>
            {
                entity.ToTable("usercredentials");

                entity.HasIndex(e => e.Login)
                    .HasName("UK_b3sujs0avamhyr8spyx118dc3")
                    .IsUnique();

                entity.HasIndex(e => e.UserId)
                    .HasName("UK_qyr3ltbyt3t9o5d8ikhkxcq9b")
                    .IsUnique();

                entity.Property(e => e.Id)
                    .HasColumnName("ID")
                    .HasColumnType("bigint(20)");

                entity.Property(e => e.Login)
                    .IsRequired()
                    .HasColumnType("varchar(255)");

                entity.Property(e => e.Password)
                    .IsRequired()
                    .HasColumnType("varchar(255)");

                entity.Property(e => e.Role)
                    .IsRequired()
                    .HasColumnType("varchar(255)");

                entity.Property(e => e.UserId)
                    .IsRequired()
                    .HasColumnType("bigint(20)");

                entity.HasOne(d => d.User)
                    .WithOne(p => p.Usercredentials)
                    .HasForeignKey<Usercredentials>(d => d.UserId)
                    .OnDelete(DeleteBehavior.Restrict)
                    .HasConstraintName("FKeon510v7wrl0xrktwd0hhosc");
            });
        }
    }
}