<script>
  export let props
</script>

<a href={props.link} >
  {props.name}
</a>

<style>
  /* 常规样式 */
  a {
    display: block;
    width: 100%; /* 对应 w-full */
    padding: 0.5rem 1rem; /* 对应 py-2 px-4 */
    border-radius: 0.375rem; /* 对应 rounded-md */
    cursor: pointer;
    text-decoration: none;
  }

  /* 悬停状态 */
  a:hover {
    background-color: #d4d4d4; /* 对应 hover:bg-gray-300 */
  }

  /* 激活状态 */
  a:active {
    border: 1px solid #3498db; /* 对应 active:ring-2 */
  }
</style>