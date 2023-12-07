<script>
  export let item;
  export let media = '';
</script>

<div class="custom-card group">
  <a href={`/${item.media_type || media}/${item.id}`} class="">
    <img src={`https://image.tmdb.org/t/p/w500${item.poster_path || item.profile_path}`} 
      alt={item.title || item.name || 'NO PICTURE FOUND'} 
      class="custom-img">
    <div class="custom-txt">
      <h4 class="custom-heading">
        {item.original_title || item.original_name || item.name}
      </h4>      
      <div class="flex justify-between">
        {#if item.release_date || item.first_air_date}
        <p class="custom-date">{item.release_date || item.first_air_date}</p>
        {/if}
        {#if item.vote_average}
        <span class="custom-rating">
          {item.vote_average.toFixed(1)}
        </span>        
        {/if}
      </div>
    </div>
  </a>
</div>

<style>
  .custom-card {
    border-radius: 1rem;
    overflow: hidden;
  }
  .custom-card:hover {
    background-color: #e5e7eb; /* 适当的灰色 */
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); /* 适当的阴影效果 */
  }
  img{
     width: 100%;
     object-fit: cover;
     border-radius: 1rem;
     margin-bottom: 1rem;
  }
  .custom-img {
    transition: all 0.3s ease; /* 适当的过渡效果 */
  }
  .custom-card:hover .custom-img {
    transform: scale(1.1); /* 鼠标悬停时放大效果 */
  }
  .custom-txt {
    padding: 0.5rem; /* p-2 */
  }
  .custom-heading {
    font-weight: 600; /* font-semibold */
    /* 文本在溢出时截断并显示省略号 */
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
  }
  /*悬停样式*/
  .custom-heading:hover {
    color: #3B82F6; /* text-blue-500 */
    opacity: 0.8;   /* 80 */
  }

  .custom-date {
    font-size: 0.875rem; /* text-sm */
  }
  .custom-rating {
    font-size: 0.875rem; /* text-sm */
    background-color: #F59E0B; /* bg-yellow-500 */
    color: #1F2937; /* text-gray-800 */
    padding: 0.25rem; /* px-1 */
    border-radius: 0.25rem; /* rounded-md */
  }
</style>