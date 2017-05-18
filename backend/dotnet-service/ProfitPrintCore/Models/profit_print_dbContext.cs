using System;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata;

namespace ProfitPrintCore.Models
{
    public partial class profit_print_dbContext : DbContext
    {
        public virtual DbSet<Customer> Customer { get; set; }
        public virtual DbSet<Document> Document { get; set; }
        public virtual DbSet<Executor> Executor { get; set; }
        public virtual DbSet<Executorserviceitem> Executorserviceitem { get; set; }
        public virtual DbSet<Order> Order { get; set; }
        public virtual DbSet<Registerkey> Registerkey { get; set; }
        public virtual DbSet<SchemaVersion> SchemaVersion { get; set; }
        public virtual DbSet<User> User { get; set; }
        public virtual DbSet<Usercredentials> Usercredentials { get; set; }

        // Unable to generate entity type for table 'orderdocument'. Please see the warning messages.

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            #warning To protect potentially sensitive information in your connection string, you should move it out of source code. See http://go.microsoft.com/fwlink/?LinkId=723263 for guidance on storing connection strings.
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

            modelBuilder.Entity<Document>(entity =>
            {
                entity.ToTable("document");

                entity.Property(e => e.Id)
                    .HasColumnName("ID")
                    .HasColumnType("bigint(20)");

                entity.Property(e => e.Link)
                    .IsRequired()
                    .HasColumnType("varchar(255)");
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

                entity.Property(e => e.Title)
                    .IsRequired()
                    .HasColumnType("varchar(255)");

                entity.Property(e => e.WebSite).HasColumnType("varchar(255)");

                entity.HasOne(d => d.IdNavigation)
                    .WithOne(p => p.Executor)
                    .HasForeignKey<Executor>(d => d.Id)
                    .OnDelete(DeleteBehavior.Restrict)
                    .HasConstraintName("FKkf2n18qxbyqiexx649hbm548m");
            });

            modelBuilder.Entity<Executorserviceitem>(entity =>
            {
                entity.ToTable("executorserviceitem");

                entity.HasIndex(e => e.ExecutorId)
                    .HasName("FKjvny1l2214ii826m7osl1hdxj");

                entity.Property(e => e.Id)
                    .HasColumnName("ID")
                    .HasColumnType("bigint(20)");

                entity.Property(e => e.Description)
                    .IsRequired()
                    .HasColumnType("varchar(255)");

                entity.Property(e => e.ExecutorId).HasColumnType("bigint(20)");

                entity.Property(e => e.Name)
                    .IsRequired()
                    .HasColumnType("varchar(255)");

                entity.Property(e => e.Price).HasColumnType("decimal(19,2)");

                entity.HasOne(d => d.Executor)
                    .WithMany(p => p.Executorserviceitem)
                    .HasForeignKey(d => d.ExecutorId)
                    .OnDelete(DeleteBehavior.Restrict)
                    .HasConstraintName("FKjvny1l2214ii826m7osl1hdxj");
            });

            modelBuilder.Entity<Order>(entity =>
            {
                entity.ToTable("order");

                entity.HasIndex(e => e.CustomerId)
                    .HasName("FKtjvhgf7nicc326156mde5rg6o");

                entity.HasIndex(e => e.ExecutorId)
                    .HasName("FKcrx82p7stqpinf18fiwfwofp3");

                entity.HasIndex(e => e.ExecutorServiceItemId)
                    .HasName("FKrtmkng3b8uxs7ypfpi6l0ntil");

                entity.Property(e => e.Id)
                    .HasColumnName("ID")
                    .HasColumnType("bigint(20)");

                entity.Property(e => e.Count).HasColumnType("int(11)");

                entity.Property(e => e.CustomerComment).HasColumnType("varchar(255)");

                entity.Property(e => e.CustomerId).HasColumnType("bigint(20)");

                entity.Property(e => e.Date).HasColumnType("datetime");

                entity.Property(e => e.Description)
                    .IsRequired()
                    .HasColumnType("varchar(255)");

                entity.Property(e => e.ExecutorId).HasColumnType("bigint(20)");

                entity.Property(e => e.ExecutorServiceItemId).HasColumnType("bigint(20)");

                entity.Property(e => e.Priority)
                    .IsRequired()
                    .HasColumnType("varchar(255)");

                entity.Property(e => e.State)
                    .IsRequired()
                    .HasColumnType("varchar(255)");

                entity.HasOne(d => d.Customer)
                    .WithMany(p => p.Order)
                    .HasForeignKey(d => d.CustomerId)
                    .OnDelete(DeleteBehavior.Restrict)
                    .HasConstraintName("FKtjvhgf7nicc326156mde5rg6o");

                entity.HasOne(d => d.Executor)
                    .WithMany(p => p.Order)
                    .HasForeignKey(d => d.ExecutorId)
                    .OnDelete(DeleteBehavior.Restrict)
                    .HasConstraintName("FKcrx82p7stqpinf18fiwfwofp3");

                entity.HasOne(d => d.ExecutorServiceItem)
                    .WithMany(p => p.Order)
                    .HasForeignKey(d => d.ExecutorServiceItemId)
                    .OnDelete(DeleteBehavior.Restrict)
                    .HasConstraintName("FKrtmkng3b8uxs7ypfpi6l0ntil");
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